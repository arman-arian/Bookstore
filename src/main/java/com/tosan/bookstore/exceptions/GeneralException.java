package com.tosan.bookstore.exceptions;

public class GeneralException extends RuntimeException {
    public GeneralException(String errorCode, String errorMessage, Throwable err) {
        super(String.format("Error %s: %s", errorCode, errorMessage), err);
    }
}