package com.xvitcoder.springbootangularyeoman.web.controller;

import com.xvitcoder.springbootangularyeoman.core.domain.Author;
import com.xvitcoder.springbootangularyeoman.core.repository.AuthorRepository;
import com.xvitcoder.springbootangularyeoman.core.service.AuthorService;
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
@RequestMapping("/author")
public class AuthorController {

    private AuthorRepository authorRepository;
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorRepository authorRepository, AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @RequestMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(authorRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return authorRepository.findById(id)
                .map(author -> new ResponseEntity<>(author, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> createAuthor(@RequestBody @Valid Author author) {
        return authorService.createAuthor(author)
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> updateAuthor(@RequestBody @Valid Author author) {
        return authorService.updateAuthor(author)
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        try {
            authorService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
