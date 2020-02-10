package com.ramcharans.central.exceptions.library;

public class FileHandlingException extends Exception {
    public FileHandlingException() {
    }

    public FileHandlingException(String message) {
        super(message);
    }

    public FileHandlingException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileHandlingException(Throwable cause) {
        super(cause);
    }

    public FileHandlingException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
