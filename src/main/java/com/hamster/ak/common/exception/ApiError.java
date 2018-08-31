package com.hamster.ak.common.exception;

import lombok.Data;

@Data
public class ApiError {

    private int code;

    private String message;

    public ApiError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    static ApiError with(String message, int code) {
        return new ApiError(code, message);
    }

}
