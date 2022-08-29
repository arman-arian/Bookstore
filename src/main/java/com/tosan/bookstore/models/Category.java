package com.tosan.bookstore.models;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Categories")
@Getter
@Setter
public class Category extends BaseEntity {
    @Column(length = 80)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SubCategory> subCategories = new HashSet<>();

    public void AddSubCategory(SubCategory subCategory) {
        getSubCategories().add(subCategory);
    }
}
