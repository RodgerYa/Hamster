package com.hamster.ak.impl;

import com.hamster.ak.api.Token;
import com.hamster.ak.api.TokenService;
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
