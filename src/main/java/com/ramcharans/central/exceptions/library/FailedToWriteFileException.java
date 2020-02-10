package com.ramcharans.central.exceptions.library;

public class FailedToWriteFileException extends Exception {
    public FailedToWriteFileException() {
    }

    public FailedToWriteFileException(String message) {
        super(message);
    }

    public FailedToWriteFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToWriteFileException(Throwable cause) {
        super(cause);
    }

    public FailedToWriteFileException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
