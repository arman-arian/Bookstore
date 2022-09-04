package com.tosan.bookstore.daos;

import com.tosan.bookstore.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends BaseRepository<Book, Long> {
    Book findByIsbn(String isbn);

    List<Book> findByTitleLike(String title);
}
