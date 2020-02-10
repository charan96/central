package com.ramcharans.central.exceptions.librarycoordinator;

public class InvalidDocumentIdException extends Exception {
    public InvalidDocumentIdException() {
    }

    public InvalidDocumentIdException(String message) {
        super(message);
    }

    public InvalidDocumentIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDocumentIdException(Throwable cause) {
        super(cause);
    }

    public InvalidDocumentIdException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
