package com.ramcharans.central.exceptions.librarycoordinator;

public class InvalidDataLocationException extends Exception {
    public InvalidDataLocationException() {
    }

    public InvalidDataLocationException(String message) {
        super(message);
    }

    public InvalidDataLocationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataLocationException(Throwable cause) {
        super(cause);
    }

    public InvalidDataLocationException(String message, Throwable cause, boolean enableSuppression,
                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
