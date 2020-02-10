package com.ramcharans.central.exceptions.library;

public class FailedToReadFileException extends Exception {
    public FailedToReadFileException() {
    }

    public FailedToReadFileException(String message) {
        super(message);
    }

    public FailedToReadFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToReadFileException(Throwable cause) {
        super(cause);
    }

    public FailedToReadFileException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
