package com.tosan.bookstore.services;

import com.tosan.bookstore.daos.CategoryRepository;
import com.tosan.bookstore.daos.SubCategoryRepository;
import com.tosan.bookstore.dtos.inputs.*;
import com.tosan.bookstore.dtos.outputs.*;
import com.tosan.bookstore.exceptions.*;
import com.tosan.bookstore.models.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService extends BaseService {
    private final CategoryRepository _categoryRepository;
    private final SubCategoryRepository _subCategoryRepository;
    private final ModelMapper _modelMapper;

    public CategoryService(
            CategoryRepository categoryRepository,
            SubCategoryRepository subCategoryRepository,
            ModelMapper modelMapper) {
        this._categoryRepository = categoryRepository;
        this._subCategoryRepository = subCategoryRepository;
        this._modelMapper = modelMapper;
    }

    public List<CategoryTreeOutputDto> GetAllCategories() {
        var categories = _categoryRepository.fetchAllCategoriesByJoinFetch();
        var outputDto = new ArrayList<CategoryTreeOutputDto>();
        categories.forEach(category ->
        {
            if (category.hasSubCategories()) {
                outputDto.add(new CategoryTreeOutputDto(category.getId(), category.getName(), true));
                for (var subCategory : category.getSubCategories()) {
                    outputDto.add(new CategoryTreeOutputDto(subCategory.getId(), subCategory.getName(), false));
                }
            }
        });

        return outputDto;
    }

    public List<CategoryOutputDto> GetCategories() {
        var outputDto = new ArrayList<CategoryOutputDto>();

        var categories = (List<Category>) _categoryRepository.findAll();

        for (var category : categories) {
            outputDto.add(_modelMapper.map(category, CategoryOutputDto.class));
        }

        return outputDto;
    }

    public List<SubCategoryOutputDto> GetSubCategories(Long categoryId) {
        var outputDto = new ArrayList<SubCategoryOutputDto>();

        var category = _categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            throw new BookStoreException(BookStoreFaults.CategoryNotExists);
        }

        for (var subCategory : category.getSubCategories()) {
            outputDto.add(_modelMapper.map(subCategory, SubCategoryOutputDto.class));
        }

        return outputDto;
    }

    public void AddCategory(CategoryInputDto inputDto) {
        var category = new Category();
        category.setName(inputDto.getName());

        _categoryRepository.save(category);
    }

    public void UpdateCategory(CategoryInputDto inputDto) {
        var category = _categoryRepository.findById(inputDto.getCategoryId()).orElse(null);
        if (category == null) {
            throw new BookStoreException(BookStoreFaults.CategoryNotExists);
        }

        category.setName(inputDto.getName());
        _categoryRepository.save(category);
    }

    public void DeleteCategory(Long categoryId) {
        var category = _categoryRepository.findById(categoryId).orElse(null);
        if (category == null) {
            throw new BookStoreException(BookStoreFaults.CategoryNotExists);
        }

        _categoryRepository.delete(category);
    }

    public void AddSubCategory(SubCategoryInputDto inputDto) {
        var category = _categoryRepository.findById(inputDto.getSubCategoryId()).orElse(null);
        if (category == null) {
            throw new BookStoreException(BookStoreFaults.CategoryNotExists);
        }

        var subCategory = new SubCategory();
        subCategory.setName(inputDto.getName());

        category.addSubCategory(subCategory);

        _categoryRepository.save(category);
    }

    public void UpdateSubCategory(SubCategoryInputDto inputDto) {
        var subCategory = _subCategoryRepository.findById(inputDto.getSubCategoryId()).orElse(null);
        if (subCategory == null) {
            throw new BookStoreException(BookStoreFaults.SubCategoryNotExists);
        }

        subCategory.setName(inputDto.getName());
        _subCategoryRepository.save(subCategory);
    }

    public void DeleteSubCategory(Long subCategoryId) {
        var subCategory = _subCategoryRepository.findById(subCategoryId).orElse(null);
        if (subCategory == null) {
            throw new BookStoreException(BookStoreFaults.SubCategoryNotExists);
        }

        _subCategoryRepository.delete(subCategory);
    }
}