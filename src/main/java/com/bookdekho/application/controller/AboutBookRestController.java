package com.bookdekho.application.controller;

import com.bookdekho.application.dto.AboutBookDTO;
import com.bookdekho.application.model.AboutBook;
import com.bookdekho.application.service.AboutBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/aboutBook")
public class AboutBookRestController {

    private static final String BOOK_DELETED = "Book Deleted";

    @Autowired
    private AboutBookService aboutBookService;

    @PostMapping(value = "/addBook")
    public ResponseEntity<AboutBookDTO> addBook(@RequestBody AboutBookDTO aboutBookDTO){
        aboutBookDTO = aboutBookService.addBook(aboutBookDTO);
        return new ResponseEntity<>(aboutBookDTO, HttpStatus.OK);
    }

    @PatchMapping(value = "/updateBook")
    public ResponseEntity<AboutBookDTO> updateBook( @RequestBody AboutBookDTO aboutBookDTO){
        //id attribute in aboutBookDTO is mandatory while update
        aboutBookDTO = aboutBookService.updateBook(aboutBookDTO);
        return new ResponseEntity<>(aboutBookDTO, HttpStatus.OK);
    }
    @GetMapping(value = "getBook/{bookId}")
    public ResponseEntity<AboutBookDTO> getBookById(@PathVariable String bookId){
        AboutBookDTO aboutBookDTO = aboutBookService.getBookById(bookId);
        return new ResponseEntity<>(aboutBookDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllBooks")
    public ResponseEntity<Page<AboutBook>> getAllBooks(@RequestParam(name = "page")int page,
                                                         @RequestParam(name = "size")int size){
        Page<AboutBook> books = aboutBookService.getAllBooks(page,size);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteBook/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId){
        aboutBookService.deleteBookById(bookId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BOOK_DELETED);
    }
}
