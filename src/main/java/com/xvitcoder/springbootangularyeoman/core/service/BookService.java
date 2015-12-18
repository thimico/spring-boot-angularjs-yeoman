package com.xvitcoder.springbootangularyeoman.core.service;

import com.xvitcoder.springbootangularyeoman.core.domain.Author;
import com.xvitcoder.springbootangularyeoman.core.domain.Book;

import java.util.Optional;

/**
 * Created by xvitcoder on 12/18/15.
 */
public interface BookService {
    Optional<Author> findBookAuthor(Book book);

    Optional<Author> findBookAuthor(Long id);

    Optional<Book> createBook(Book book);

    Optional<Book> updateBook(Book book);

    void deleteBook(Long id);
}
