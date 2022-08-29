package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long>  {
}
