package com.hamster.ak.user.api;

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
     * 解码
     *
     * @param values
     * @return
     */
    Token decodeToken(String values);
}
