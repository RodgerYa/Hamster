package com.hamster.ak.common.web;

import com.hamster.ak.api.PreHandleResponseVO;
import com.hamster.ak.api.Token;
import com.hamster.ak.api.TokenService;
import com.hamster.ak.api.User;
import com.hamster.ak.common.bean.ThreadLocalUser;
import com.hamster.ak.common.exception.HmException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import static com.hamster.ak.common.exception.HmError.TOKEN_NOT_EXIST;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.HttpHeaders.CACHE_CONTROL;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Component
@Log4j2
@SuppressWarnings("checkstyle:StaticVariableName")
public class HmInterceptor extends HandlerInterceptorAdapter {

    private static final String UTF_8 = "utf-8";

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        try {
            log.info("request URI: " + request.getRequestURI());

            String tokenStr = request.getHeader("token");
            if (StringUtils.isEmpty(tokenStr)) {
                throw new HmException(TOKEN_NOT_EXIST);
            }
            Token token = tokenService.decodeToken(tokenStr);

            // 这里需要注意存储在 threadLocal 中的 user 仅有 id/name 两个属性
            // FIXME @yanwenbo oncePerRequest、RequestListener、webSocket 都在 HandleInterceptorAdapter之前
            ThreadLocalUser.setUser(User.builder()
                    .id(token.getUserId())
                    .name(token.getUserName()).build());
            return true;
        } catch (Exception ex) {
            log.error("验签失败", ex);

            response.setStatus(SC_OK);
            response.setContentType(APPLICATION_JSON_VALUE);
            response.setHeader(CACHE_CONTROL, "no-store");
            response.setCharacterEncoding(UTF_8);
            PrintWriter pw = response.getWriter();

            String msg;
            HttpStatus code;
            if (ex instanceof HmException) {
                msg = "验签失败, 请重新确认身份";
                code = HttpStatus.UNAUTHORIZED;
            } else {
                msg = "验签失败, 系统错误";
                code = HttpStatus.INTERNAL_SERVER_ERROR;
            }
            pw.print(PreHandleResponseVO.builder()
                    .message(msg)
                    .code(code.value())
                    .success(false).build().toJson());
            pw.flush();
            return false;
        }
    }
}
