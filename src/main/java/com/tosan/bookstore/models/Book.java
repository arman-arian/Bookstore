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

    @Column(name = "buy_price", precision = 7, scale = 2, nullable = false)
    private BigDecimal buyPrice;

    @Column(name = "rent_price", precision = 7, scale = 2)
    private BigDecimal rentPrice;

    @Column(name = "pub_name", length = 200)
    private String pubName;

    @Column(name = "pub_date")
    private LocalDate pubDate;

    @Column(name = "pub_year")
    private Integer pubYear;

    @Column(length = 400)
    private String summary;

    @Column(name = "image_url", length = 400)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Override
    public String toString() {
        return String.format("%s by %s", getTitle(), getAuthor());
    }
}
