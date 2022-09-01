package com.tosan.bookstore.services;

import com.tosan.bookstore.daos.BookRepository;
import com.tosan.bookstore.daos.CategoryRepository;
import com.tosan.bookstore.dtos.outputs.CategoryTreeOutputDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends BaseService {
    private final CategoryRepository _categoryRepository;

    private final ModelMapper _modelMapper;

    public CategoryService(BookRepository bookRepository, CategoryRepository CategoryRepository, ModelMapper modelMapper) {
        this._categoryRepository = CategoryRepository;
        this._modelMapper = modelMapper;
    }

    public List<CategoryTreeOutputDto> GetAllCategories() {
        final var categories = _categoryRepository.fetchAllCategoriesByJoinFetch();
        List<CategoryTreeOutputDto> result = new ArrayList<>();
        categories.forEach(category ->
        {
            if (category.hasSubCategories()) {
                result.add(new CategoryTreeOutputDto(category.getId(), category.getName(), true));
                for (var subCategory : category.getSubCategories()) {
                    result.add(new CategoryTreeOutputDto(subCategory.getId(), subCategory.getName(), false));
                }
            }
        });

        return result;
    }

    public void GetCategories() {
    }

    public void GetSubCategories(Long categoryId) {
    }

    public void AddCategory() {
    }

    public void UpdateCategory() {
    }

    public void DeleteCategory() {
    }

    public void AddSubCategory() {
    }

    public void UpdateSubCategory() {
    }

    public void DeleteSubCategory() {
    }
}