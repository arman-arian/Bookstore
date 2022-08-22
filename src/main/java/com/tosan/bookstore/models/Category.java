package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Categories")
@Getter
@Setter
public class Category extends BaseEntity {
    @Column(length = 80)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Book> books;
}
