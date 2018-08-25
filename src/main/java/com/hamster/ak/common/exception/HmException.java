package com.hamster.ak.common.exception;

/**
 * @author yanwenbo
 */
public class HmException extends RuntimeException {

    private Integer code;

    public HmException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public HmException(String message) {
        super(message);
    }

    public HmException(Throwable cause) {
        super(cause);
    }

    public HmException(String message, Throwable cause) {
        super(message, cause);
    }
}
