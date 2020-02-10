package com.ramcharans.central.exceptions.library;

public class FileNotExistsException extends Exception {
    public FileNotExistsException() {
    }

    public FileNotExistsException(String message) {
        super(message);
    }

    public FileNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotExistsException(Throwable cause) {
        super(cause);
    }

    public FileNotExistsException(String message, Throwable cause, boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
