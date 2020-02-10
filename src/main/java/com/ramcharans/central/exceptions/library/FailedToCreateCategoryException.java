package com.ramcharans.central.exceptions.library;

public class FailedToCreateCategoryException extends Exception {

    public FailedToCreateCategoryException() {
    }

    public FailedToCreateCategoryException(String message) {
        super(message);
    }

    public FailedToCreateCategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToCreateCategoryException(Throwable cause) {
        super(cause);
    }

    public FailedToCreateCategoryException(String message, Throwable cause, boolean enableSuppression,
                                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
