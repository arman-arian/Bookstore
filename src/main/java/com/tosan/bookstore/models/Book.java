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

    private long buyPrice;

    private long rentPrice;

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

    public Book() {
    }

    public Book(String title, String author, String isbn, long buyPrice, long rentPrice, String pubName, LocalDate pubDate, int pubYear, String description, String createdBy) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.buyPrice = buyPrice;
        this.rentPrice = rentPrice;
        this.pubName = pubName;
        this.pubDate = pubDate;
        this.pubYear = pubYear;
        this.description = description;
        this.isDeleted = false;
        this.createdOn = LocalDateTime.now();
        this.createdBy = createdBy;
        this.modifiedOn = null;
        this.modifiedBy = null;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public long getBuyPrice() {
        return buyPrice;
    }

    public long getRentPrice() {
        return rentPrice;
    }

    public String getPubName() {
        return pubName;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public int getPubYear() {
        return pubYear;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }
}