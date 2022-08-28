package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Sub_Categories")
@Getter
@Setter
public class SubCategory extends BaseEntity {
    @Column(length = 80)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "subCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public void AddBook(Book book)
    {
        getBooks().add(book);
    }
}
