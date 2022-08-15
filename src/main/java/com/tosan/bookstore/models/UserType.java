package com.tosan.bookstore.models;

public enum UserType implements BaseEnum {
    User("کاربر عادی"),
    Member("عضو کتابخانه"),
    Librarian("کتابدار");

    private final String description;

    UserType(String description)
    {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
