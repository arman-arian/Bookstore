package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long>  {
    // https://medium.com/nerd-for-tech/how-to-eager-load-when-theres-lazy-loading-involved-57753644834e
    @Query(value = "SELECT d FROM Category d JOIN FETCH d.subCategories")
    Set<Category> fetchAllCategoriesByJoinFetch();
}
