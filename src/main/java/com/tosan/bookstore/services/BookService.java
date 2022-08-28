package com.tosan.bookstore.services;

import com.tosan.bookstore.daos.BookRepository;
import com.tosan.bookstore.daos.SubCategoryRepository;
import com.tosan.bookstore.dtos.inputs.BookInputDto;
import com.tosan.bookstore.dtos.outputs.BookOutputDto;
import com.tosan.bookstore.exceptions.BookStoreException;
import com.tosan.bookstore.exceptions.BookStoreFaults;
import com.tosan.bookstore.models.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService extends BaseService {
    private final BookRepository _bookRepository;

    private final SubCategoryRepository _subCategoryRepository;

    private final ModelMapper _modelMapper;

    public BookService(BookRepository bookRepository, SubCategoryRepository subCategoryRepository, ModelMapper modelMapper) {
        this._bookRepository = bookRepository;
        this._subCategoryRepository = subCategoryRepository;
        this._modelMapper = modelMapper;
    }

    public List<BookOutputDto> GetBooks(Long subCategoryId) {
        List<BookOutputDto> outputDto = new ArrayList<>();

        var subCategory = _subCategoryRepository.findById(subCategoryId).orElse(null);
        if (subCategory == null)
            throw new BookStoreException(BookStoreFaults.SubCategoryNotExists);

        var books = subCategory.getBooks();
        for (Book book : books) {
            outputDto.add(_modelMapper.map(book, BookOutputDto.class));
        }

        return outputDto;
    }

    public BookOutputDto GetBook(Long id) {
        var book = _bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new BookStoreException(BookStoreFaults.BookNotExists);
        }

        return _modelMapper.map(book, BookOutputDto.class);
    }

    public void AddBook(BookInputDto inputDto) {
        var subCategory = _subCategoryRepository.findById(inputDto.getSubCategoryId()).orElse(null);
        if (subCategory == null)
            throw new BookStoreException(BookStoreFaults.SubCategoryNotExists);

        var book = _modelMapper.map(inputDto, Book.class);
        subCategory.AddBook(book);

        _subCategoryRepository.save(subCategory);
    }

    public void UpdateBook(BookInputDto inputDto) {
        var book = _bookRepository.findById(inputDto.getId()).orElse(null);
        if (book == null) {
            throw new BookStoreException(BookStoreFaults.BookNotExists);
        }

        var subCategory = _subCategoryRepository.findById(inputDto.getSubCategoryId()).orElse(null);
        if (subCategory == null)
            throw new BookStoreException(BookStoreFaults.SubCategoryNotExists);

        _modelMapper.map(inputDto, book);

        book.setSubCategory(subCategory);

        _bookRepository.save(book);
    }

    public void DeleteBook(Long id) {
        var book = _bookRepository.findById(id).orElse(null);
        if (book == null) {
            throw new BookStoreException(BookStoreFaults.BookNotExists);
        }

        _bookRepository.delete(book);
    }
}
