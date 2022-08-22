package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.*;

@Entity
@Table(name = "Books")
@Getter
@Setter
public class Book extends BaseEntity {
    @Column(length = 200, nullable = false, unique = true)
    private String title;

    @Column(length = 400, nullable = false)
    private String author;

    @Column(length = 20, unique = true)
    private String isbn;

    @Column(nullable = false)
    private Long price;

    @Column(precision = 1, scale = 2)
    private BigDecimal rentRate;

    @Column(length = 200)
    private String pubName;

    private LocalDate pubDate;

    private Integer pubYear;

    @Column(length = 400)
    private String summary;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Override
    public String toString() {
        return String.format("%s by %s", getTitle(), getAuthor());
    }
}
