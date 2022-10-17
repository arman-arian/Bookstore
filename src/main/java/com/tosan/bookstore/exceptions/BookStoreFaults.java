package com.tosan.bookstore.exceptions;

import java.text.MessageFormat;

public enum BookStoreFaults {
    UserNotExists("User not found"),
    UserNotActive("User is not active"),
    UserLoginFailed("Invalid Username or password"),
    UserSameOldAndNewPassword("New password is similar to old password"),
    UserEmptyUsername("Username is empty"),
    UserEmptyPassword("Password is empty"),
    CategoryNotExists("Category is not found"),
    SubCategoryNotExists("SubCategory is not found"),
    BookNotExists("Book is not found"),
    InvoiceNotExists("Invoice is not found"),
    InvoiceItemNotExists("Invoice item is not found"),

    InvalidArguments("Input arguments are invalid"),
    UnknownError("");

    private final String description;

    BookStoreFaults(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getDescription(Object... args)
    {
        MessageFormat messageFormat = new MessageFormat(getDescription());
        return messageFormat.format(args);
    }

    @Override
    public String toString() {
        return description;
    }
}