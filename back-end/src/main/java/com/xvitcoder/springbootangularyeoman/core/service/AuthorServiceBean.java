package com.xvitcoder.springbootangularyeoman.core.service;

import com.xvitcoder.springbootangularyeoman.core.domain.Author;
import com.xvitcoder.springbootangularyeoman.core.domain.Book;
import com.xvitcoder.springbootangularyeoman.core.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by xvitcoder on 12/18/15.
 */
@Service
@Transactional
public class AuthorServiceBean implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceBean(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<List<Book>> findAuthorBooks(Author author) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<List<Book>> findAuthorBooks(Long id) {
        return null;
    }

    @Override
    public Optional<Author> createAuthor(Author author) {
        return null;
    }

    @Override
    public Optional<Author> updateAuthor(Author author) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }
}
