package com.xvitcoder.springbootangularyeoman.core.service;

import com.xvitcoder.springbootangularyeoman.core.domain.Author;
import com.xvitcoder.springbootangularyeoman.core.domain.Book;

import java.util.List;
import java.util.Optional;

/**
 * Created by xvitcoder on 12/18/15.
 */
public interface AuthorService {
    Optional<List<Book>> findAuthorBooks(Author author);

    Optional<List<Book>> findAuthorBooks(Long id);

    Optional<Author> createAuthor(Author author);

    Optional<Author> updateAuthor(Author author);

    void deleteBook(Long id);
}
