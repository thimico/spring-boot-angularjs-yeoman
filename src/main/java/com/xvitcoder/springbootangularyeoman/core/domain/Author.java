package com.xvitcoder.springbootangularyeoman.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xvitcoder on 12/18/15.
 */
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 3, max = 32)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 32)
    private String lastName;

    @NotNull
    @Email
    @Size(max = 100)
    @Column(length = 100, unique = true)
    private String email;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "author_books",
            joinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "author", referencedColumnName = "id")})
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
