package com.aliboucoding.JPA.services;

import com.aliboucoding.JPA.models.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    List<Author> getAllAuthorByName(String nameAuthor);

    Author getAuthors(int idAuthor);

    void deleteAuthor(int idAuthor);

    Author updateAuthor(Author author);

}
