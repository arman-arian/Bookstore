package com.tosan.bookstore.models;

public enum InvoiceState implements BaseEnum {
    Draft,
    Deleted,
    Issued,
    Cancelled,
    Expired,
    Paid
}
