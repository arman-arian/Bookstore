package com.tosan.bookstore.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 200, nullable = false, unique = true)
    private String title;

    @Column(length = 400, nullable = false)
    private String author;

    @Column(length = 20)
    private String isbn;

    @Column(nullable = false)
    private Long buyPrice;

    @Column(precision = 1, scale = 2)
    private BigDecimal rentRate;

    @Column(length = 200)
    private String pubName;

    private LocalDate pubDate;

    private Integer pubYear;

    @Column(length = 400)
    private String description;

    private Boolean isDeleted;

    private LocalDateTime createdOn;

    @Column(length = 40)
    private String createdBy;

    private LocalDateTime modifiedOn;

    @Column(length = 40)
    private String modifiedBy;

    public Book() {
    }

    public Book(String title, String author, String isbn, Long buyPrice, BigDecimal rentRate,
                String pubName, LocalDate pubDate, Integer pubYear, String description,
                String createdBy) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.buyPrice = buyPrice;
        this.rentRate = rentRate;
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

    public Long getId() {
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

    public Long getBuyPrice() {
        return buyPrice;
    }

    public BigDecimal getRentRate() {
        return rentRate;
    }

    public String getPubName() {
        return pubName;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public Integer getPubYear() {
        return pubYear;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isDeleted() {
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
