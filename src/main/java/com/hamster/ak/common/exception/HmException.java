package com.hamster.ak.common.exception;

import lombok.Data;

/**
 * @author yanwenbo
 */
@Data
public class HmException extends RuntimeException {

    private Integer code;

    public HmException(ApiError error) {
        super(error.getMessage());
        this.code = error.getCode();
    }
}
