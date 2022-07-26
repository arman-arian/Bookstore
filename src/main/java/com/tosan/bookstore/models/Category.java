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

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SubCategory> subCategories = new HashSet<>();

    public void addSubCategory(SubCategory subCategory) {
        subCategory.setCategory(this);
        getSubCategories().add(subCategory);
    }

    public void removeSubCategory(SubCategory subCategory) {
        getSubCategories().remove(subCategory);
    }

    public boolean hasSubCategories() {
        return getSubCategories().size() > 0;
    }
}
