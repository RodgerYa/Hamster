package com.hamster.ak.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hamster.ak.api.Token;
import com.hamster.ak.api.TokenService;
import com.hamster.ak.common.config.HmProperties;
import com.hamster.ak.common.exception.HmException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.hamster.ak.common.exception.HmError.*;

@Component
@Slf4j
public class TokenServiceImpl implements TokenService {

    private static final String SECRET = "RfuUZH7SnjvXbwen7joNmbLKCdfEFbDZBRKxldBfZIcuZ";

    @Autowired
    private HmProperties hmProperties;

    @Override
    public String encodeToken(Token token) {

        HashMap header = new HashMap<String, String>(2) {{
            put("typ", "JWT");
            put("alg", "RSA");
        }};

        try {
            return JWT.create().withHeader(header)
                    .withExpiresAt(token.getExpiration())
                    .withIssuedAt(new Date())
                    .withIssuer("hm")
                    .withClaim("userId", token.getUserId())
                    .withClaim("userName", token.getUserName())
                    .sign(Algorithm.HMAC256(hmProperties.getSecret()));

        } catch (Exception e) {
            log.error("token加密失败, token: ", token.toString());
            throw new HmException(TOKEN_ENCODE_ERROR);
        }
    }

    @Override
    public Token decodeToken(String sign) {
        if (StringUtils.isEmpty(sign)) {
            log.error("token 不存在");
            throw new HmException(TOKEN_NOT_EXIST);
        }
        if (hmProperties == null) {
            hmProperties = new HmProperties();
        }
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;

        try {
            jwt = verifier.verify(sign);
        } catch (TokenExpiredException e) {
            log.error("token 过期", e);
            throw new HmException(TOKEN_EXPIRED);
        } catch (JWTDecodeException e) {
            log.error("token 验证失败, tokenSign: " + sign);
            throw new HmException(TOKEN_INVALID);
        }

        Map<String, Claim> claims = jwt.getClaims();

        return Token.builder().expiration(claims.get("exp").asDate())
                .userId(claims.get("userId").asInt())
                .userName(claims.get("userName").asString())
                .build();
    }
}
