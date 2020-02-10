package com.ramcharans.central.exceptions.librarycoordinator;

public class NoLocationFoundForIdException extends Exception {
    public NoLocationFoundForIdException() {
    }

    public NoLocationFoundForIdException(String message) {
        super(message);
    }

    public NoLocationFoundForIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoLocationFoundForIdException(Throwable cause) {
        super(cause);
    }

    public NoLocationFoundForIdException(String message, Throwable cause, boolean enableSuppression,
                                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
