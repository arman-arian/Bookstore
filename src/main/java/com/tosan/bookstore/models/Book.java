package com.tosan.bookstore.models;

import java.time.LocalDate;

public class Book {
    private long id;

    private String title;

    private String author;

    private String pubName;

    private LocalDate pubDate;

    private int pubYear;

    private String isbn;

    private long price;

    private String description;

    private boolean isDeleted;

    private LocalDate createdOn;

    private String createdBy;

    private LocalDate modifiedOn;

    private String modifiedBy;
}
