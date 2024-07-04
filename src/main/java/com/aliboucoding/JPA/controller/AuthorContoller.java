package com.aliboucoding.JPA.controller;

import com.aliboucoding.JPA.models.Author;
import com.aliboucoding.JPA.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorContoller {

    private final AuthorService authorService;

    public AuthorContoller(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable("id") Integer id) {
        Author author = authorService.getAuthors(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.updateAuthor(author), HttpStatus.OK);
    }
}
