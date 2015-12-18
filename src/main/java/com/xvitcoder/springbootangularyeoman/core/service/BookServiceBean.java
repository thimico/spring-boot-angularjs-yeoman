package com.xvitcoder.springbootangularyeoman.core.service;

import com.xvitcoder.springbootangularyeoman.core.domain.Author;
import com.xvitcoder.springbootangularyeoman.core.domain.Book;
import com.xvitcoder.springbootangularyeoman.core.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by xvitcoder on 12/18/15.
 */
@Service
@Transactional
public class BookServiceBean implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceBean(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Transactional(readOnly = true)
    @Override
    public Optional<Author> findBookAuthor(Book book) {
        return Optional.of(book.getAuthor());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Author> findBookAuthor(Long id) {
        return bookRepository.findById(id)
                .map(book -> book.getAuthor());
    }

    @Override
    public Optional<Book> createBook(Book book) {
        return book.getId() == null ?
                Optional.of(bookRepository.save(book)) :
                Optional.empty();
    }

    @Override
    public Optional<Book> updateBook(Book book) {
        return book.getId() != null ?
                Optional.of(bookRepository.save(book)) :
                Optional.empty();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }
}
