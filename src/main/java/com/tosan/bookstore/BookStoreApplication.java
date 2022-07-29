package com.tosan.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {
        //SpringApplication.run(BookStoreApplication.class, args);

        SpringApplication app = new SpringApplication(BookStoreApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
    }
}
