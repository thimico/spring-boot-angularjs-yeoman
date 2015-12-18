package com.xvitcoder.springbootangularyeoman.core.repository;

import com.xvitcoder.springbootangularyeoman.core.domain.Author;
import com.xvitcoder.springbootangularyeoman.core.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by xvitcoder on 12/18/15.
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Book> findById(Long id);
}
