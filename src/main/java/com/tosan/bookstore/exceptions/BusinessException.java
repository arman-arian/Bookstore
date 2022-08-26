package com.tosan.bookstore.exceptions;

import java.text.MessageFormat;

public class BusinessException extends RuntimeException {
    public BusinessException(FaultCodes fault) {
        super(String.format("Error %s: %s", fault.ordinal(), fault.getDescription()));
    }

    public BusinessException(FaultCodes fault, Object... args) {
        super(String.format("Error %s: %s", fault.ordinal(), new MessageFormat(fault.getDescription()).format(args)));
    }

    public BusinessException(FaultCodes fault, Throwable err) {
        super(String.format("Error %s: %s", fault.ordinal(), fault.getDescription()), err);
    }
}
