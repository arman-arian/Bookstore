package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

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

    @Column(name = "pub_year")
    private Integer pubYear;

    @Column(length = 400)
    private String summary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;

    public Book()
    {

    }

    public Book(Long id)
    {
        this.setId(id);
    }

    @Override
    public String toString() {
        return String.format("%s by %s", getTitle(), getAuthor());
    }
}
