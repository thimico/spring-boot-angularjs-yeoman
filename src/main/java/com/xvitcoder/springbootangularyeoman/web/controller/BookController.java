package com.xvitcoder.springbootangularyeoman.web.controller;

import com.xvitcoder.springbootangularyeoman.core.domain.Book;
import com.xvitcoder.springbootangularyeoman.core.repository.BookRepository;
import com.xvitcoder.springbootangularyeoman.core.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by xvitcoder on 12/18/15.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;
    private BookService bookService;

    @Autowired
    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @RequestMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> createBook(@RequestBody @Valid Book book) {
        return bookService.createBook(book)
                .map(b -> new ResponseEntity<>(b, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> updateBook(@RequestBody @Valid Book book) {
        return bookService.updateBook(book)
                .map(b -> new ResponseEntity<>(b, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
