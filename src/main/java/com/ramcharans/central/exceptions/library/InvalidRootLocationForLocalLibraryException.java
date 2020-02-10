package com.ramcharans.central.exceptions.library;

public class InvalidRootLocationForLocalLibraryException extends Exception {

    public InvalidRootLocationForLocalLibraryException() {
    }

    public InvalidRootLocationForLocalLibraryException(String message) {
        super(message);
    }

    public InvalidRootLocationForLocalLibraryException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRootLocationForLocalLibraryException(Throwable cause) {
        super(cause);
    }

    public InvalidRootLocationForLocalLibraryException(String message, Throwable cause, boolean enableSuppression,
                                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
