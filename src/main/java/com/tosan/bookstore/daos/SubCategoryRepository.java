package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.SubCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends BaseRepository<SubCategory, Long>  {
    List<SubCategory> findByCategoryId(Long categoryId);
}
