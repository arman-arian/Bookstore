package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends BaseRepository<Book, Long> {
    Book findByIsbn(String isbn);
}
