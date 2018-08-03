package com.hamster.ak.user.impl;

import com.hamster.ak.user.api.Token;
import com.hamster.ak.user.api.TokenService;
import org.springframework.stereotype.Component;

@Component
public class TokenServiceImpl implements TokenService {
    @Override
    public String encodeToken(Token token) {
        return null;
    }

    @Override
    public Token decodeToken(String values) {
        return null;
    }
}
