package com.ramcharans.central.exceptions.library;

public class InvalidCategoryNameException extends Exception {
    public InvalidCategoryNameException() {
    }

    public InvalidCategoryNameException(String message) {
        super(message);
    }

    public InvalidCategoryNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCategoryNameException(Throwable cause) {
        super(cause);
    }

    public InvalidCategoryNameException(String message, Throwable cause, boolean enableSuppression,
                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
