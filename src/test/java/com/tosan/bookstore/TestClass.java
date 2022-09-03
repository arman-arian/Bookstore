package com.tosan.bookstore;

import com.tosan.bookstore.exceptions.BookStoreFaults;

import javax.validation.constraints.NotEmpty;

public class TestClass {
    @NotEmpty(message = "Username is empty")
    private String username;

    @NotEmpty(message = "Password is empty")
    private String password;
}
