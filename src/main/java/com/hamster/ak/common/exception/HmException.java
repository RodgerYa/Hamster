package com.hamster.ak.common.exception;

/**
 * @author yanwenbo
 */
public class HmException extends Exception {

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
