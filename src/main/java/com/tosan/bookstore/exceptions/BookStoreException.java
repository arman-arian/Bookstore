package com.tosan.bookstore.exceptions;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class BookStoreException extends RuntimeException {
    private final BookStoreFaults fault;

    private final Object[] args;

    public BookStoreException(BookStoreFaults fault) {
        super(String.format("Error %s: %s", fault.ordinal(), fault.getDescription()));
        this.fault = fault;
        this.args = new Object[0];
    }

    public BookStoreException(BookStoreFaults fault, Object... args) {
        super(String.format("Error %s: %s", fault.ordinal(), fault.getDescription(args)));
        this.fault = fault;
        this.args = args;
    }

    public BookStoreException(BookStoreFaults fault, Throwable err) {
        super(String.format("Error %s: %s", fault.ordinal(), fault.getDescription()), err);
        this.fault = fault;
        this.args = new Object[0];
    }

    public BookStoreFaults getFault() {
        return fault;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getFaultMessage() {
        if (getArgs().length == 0) {
            return getFault().getDescription();
        } else {
            return getFault().getDescription(getArgs());
        }
    }

    public String getLocaleFaultMessage(String locale) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("messages");
            if (getArgs().length == 0) {
                return bundle.getString(getFault().toString());
            } else {
                MessageFormat messageFormat = new MessageFormat(bundle.getString(getFault().toString()));
                return messageFormat.format(getArgs());
            }
        } catch (MissingResourceException ex) {
            return getFaultMessage();
        }
    }
}
