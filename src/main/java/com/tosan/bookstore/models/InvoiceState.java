package com.tosan.bookstore.models;

public enum InvoiceState {
    Draft("پیش نویس"),
    Deleted("حذف شده"),
    Issued("صادر شده"),
    Cancelled("انصراف داده  شده"),
    Expired("منقضی شده"),
    Paid("پرداخت شده");

    private final String description;

    InvoiceState(String description)
    {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
