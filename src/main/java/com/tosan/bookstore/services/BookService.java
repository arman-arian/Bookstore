package com.tosan.bookstore.services;

import com.tosan.bookstore.daos.BookRepository;
import com.tosan.bookstore.dtos.outputs.BookOutputDto;
import com.tosan.bookstore.exceptions.GeneralException;
import com.tosan.bookstore.models.Book;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final BookRepository repository;
    private final ModelMapper modelMapper;

    public BookService(BookRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<BookOutputDto> GetBooks() {
        try {
            List<BookOutputDto> outputDto = new ArrayList<>();
            List<Book> books = (List<Book>) repository.findAll();

            for (Book book : books) {
                outputDto.add(modelMapper.map(book, BookOutputDto.class));
            }

            return outputDto;
        } catch (Exception ex) {
            throw new GeneralException("1003", "GetBooks Error", ex);
        }
    }
}
