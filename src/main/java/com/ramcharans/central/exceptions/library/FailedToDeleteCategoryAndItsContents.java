package com.ramcharans.central.exceptions.library;

public class FailedToDeleteCategoryAndItsContents extends Exception {
    public FailedToDeleteCategoryAndItsContents() {
    }

    public FailedToDeleteCategoryAndItsContents(String message) {
        super(message);
    }

    public FailedToDeleteCategoryAndItsContents(String message, Throwable cause) {
        super(message, cause);
    }

    public FailedToDeleteCategoryAndItsContents(Throwable cause) {
        super(cause);
    }

    public FailedToDeleteCategoryAndItsContents(String message, Throwable cause, boolean enableSuppression,
                                                boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
