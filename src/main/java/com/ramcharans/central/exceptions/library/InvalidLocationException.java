package com.ramcharans.central.exceptions.library;

public class InvalidLocationException extends Exception {

    public InvalidLocationException() {
    }

    public InvalidLocationException(String message) {
        super(message);
    }

    public InvalidLocationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidLocationException(Throwable cause) {
        super(cause);
    }

    public InvalidLocationException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
