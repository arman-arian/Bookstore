package com.tosan.bookstore.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class GeneralException extends RuntimeException {
    private final String errorCode;

    private final String errorMsg;

    public GeneralException(String errorCode, String errorMsg, Throwable err) {
        super(String.format("Error %s: %s", errorCode, errorMsg), err);

        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public GeneralException(String errorCode, String errorMsg) {
        super(String.format("Error %s: %s", errorCode, errorMsg));

        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public GeneralException(String errorMsg) {
        super(String.format("Error %s", errorMsg));

        this.errorCode = "9999";
        this.errorMsg = errorMsg;
    }
}