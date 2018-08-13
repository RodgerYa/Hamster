package com.hamster.ak.api;

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
     *
     * @param sign
     * @return
     */
    Token decodeToken(String sign);
}
