package com.hamster.ak.user.api;

import org.springframework.stereotype.Service;

/**
 * @author yanwenbo
 */
public interface TokenService {

    /**
     * 编码
     *
     * @param token
     * @return
     */
    String encodeToken(Token token);

    /**
     * 解码 + 验签
     * @param values
     * @return
     */
    Token decodeToken(String values);
}
