package com.aliboucoding.JPA.services;

import com.aliboucoding.JPA.models.Author;
import com.aliboucoding.JPA.repositories.AuthorRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthorByName(String nameAuthor) {
        return authorRepository.findAllByFirstName(nameAuthor);
    }

    @Override
    public Author getAuthors(int idAuthor) {
        return authorRepository.getReferenceById(idAuthor);
    }

    @Override
    public void deleteAuthor(int idAuthor) {
        authorRepository.deleteById(idAuthor);
    }

    @Override
    public Author updateAuthor(Author author) {
        if (!authorRepository.existsById(author.getId())) {
            throw new RuntimeException("Author with id " + author.getId() + " not found");
        }
        return authorRepository.save(author);
    }
}
