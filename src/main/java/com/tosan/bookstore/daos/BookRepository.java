package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByIsbn(String isbn);
}
