package com.tosan.bookstore.controllers;

import com.tosan.bookstore.daos.BookRepository;
import com.tosan.bookstore.dtos.BookDto;
import com.tosan.bookstore.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping(value = "/getBooks")
    public ResponseEntity<List<BookDto>> GetAllBooks()
    {
        try
        {
            List<Book> books = (List<Book>) repository.findAll();
            List<BookDto> bookDtoList = new ArrayList<>();
            for(Book book : books)
            {
                BookDto bookDto = new BookDto(book.getId(), book.getTitle(), book.getAuthor(),
                        book.getIsbn(), book.getBuyPrice(), book.getRentRate(), book.getPubName(),
                        book.getPubDate(), book.getPubYear(), book.getDescription(),
                        book.isDeleted(), book.getCreatedOn(), book.getCreatedBy(),
                        book.getModifiedOn(), book.getModifiedBy());

                bookDtoList.add(bookDto);
            }

            return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
        }
        catch (Exception ex)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unhandled Exception Has Occurred", ex);
        }
    }

}
