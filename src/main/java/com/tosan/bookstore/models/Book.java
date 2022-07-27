package com.tosan.bookstore.models;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue
    private long id;

    @Column(length=200, nullable = false, unique = true)
    private String title;

    @Column(length=400, nullable = false)
    private String author;

    @Column(length=20)
    private String isbn;

    private long price;

    @Column(length=200)
    private String pubName;

    private LocalDate pubDate;

    private int pubYear;

    @Column(length=800)
    private String description;

    private boolean isDeleted;

    private LocalDateTime createdOn;

    @Column(length=40)
    private String createdBy;

    private LocalDateTime modifiedOn;

    @Column(length=40)
    private String modifiedBy;
}
