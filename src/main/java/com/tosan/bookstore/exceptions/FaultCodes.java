package com.tosan.bookstore.exceptions;

public enum FaultCodes  {
    UserNotExists("User not found"),
    UserNotActive("User is not active"),
    UserLoginFailed("Invalid Username or password"),
    UserSameOldAndNewPassword("New password is similar to old password"),

    UnknownError("");

    private final String description;

    FaultCodes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
