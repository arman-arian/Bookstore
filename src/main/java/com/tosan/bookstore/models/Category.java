package com.tosan.bookstore.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "Categories")
@Getter
@Setter
public class Category extends BaseEntity {
    @Column(length = 200)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Book> books;
}
