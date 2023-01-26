package com.bookdekho.application.controller;

import com.bookdekho.application.dto.AuthorDTO;
import com.bookdekho.application.model.Author;
import com.bookdekho.application.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/author")
public class AuthorRestController {

    @Autowired
    private AuthorService authorService;
    private static final String AUTHOR_DELETED = "Author Deleted";

    @PostMapping(value = "/addAuthor")
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorDTO){
        authorDTO = authorService.addAuthor(authorDTO);
        return new ResponseEntity<>(authorDTO, HttpStatus.OK);
    }

    @PatchMapping(value = "/updateAuthor")
    public ResponseEntity<AuthorDTO> updateAuthor( @RequestBody AuthorDTO authorDTO){
        //id attribute in authorDto is mandatory while update
        authorDTO = authorService.updateAuthor(authorDTO);
        return new ResponseEntity<>(authorDTO, HttpStatus.OK);
    }
    @GetMapping(value = "getAuthor/{authorId}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable String authorId){
        AuthorDTO authorDTO = authorService.getAuthorById(authorId);
        return new ResponseEntity<>(authorDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllAuthors")
    public ResponseEntity<Page<Author>> getAllAuthors(@RequestParam(name = "page")int page,
                                                    @RequestParam(name = "size")int size){
        Page<Author> authors = authorService.getAllAuthors(page,size);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAuthor/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable String authorId){
        authorService.deleteAuthorById(authorId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(AUTHOR_DELETED);
    }


}
