package com.bookdekho.application.controller;

import com.bookdekho.application.dto.BookReviewDTO;
import com.bookdekho.application.model.BookReview;
import com.bookdekho.application.service.BookReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bookReview")
public class BookReviewRestController {
    private static final String REVIEW_DELETED = "Review Deleted";

    @Autowired
    private BookReviewService bookReviewService;

    @PostMapping(value = "/addBookReview")
    public ResponseEntity<BookReviewDTO> addBookReview(@RequestBody BookReviewDTO bookReviewDTO){
        bookReviewDTO = bookReviewService.addBookReview(bookReviewDTO);
        return new ResponseEntity<>(bookReviewDTO, HttpStatus.OK);
    }

    @PatchMapping(value = "/updateBookReview")
    public ResponseEntity<BookReviewDTO> updateBookReview( @RequestBody BookReviewDTO bookReviewDTO){
        //id attribute in bookReviewDTO is mandatory while update
        bookReviewDTO = bookReviewService.updateBookReview(bookReviewDTO);
        return new ResponseEntity<>(bookReviewDTO, HttpStatus.OK);
    }
    @GetMapping(value = "getBookReview/{bookReviewId}")
    public ResponseEntity<BookReviewDTO> getBookReviewById(@PathVariable String bookReviewId){
        BookReviewDTO bookReviewDTO = bookReviewService.getBookReviewById(bookReviewId);
        return new ResponseEntity<>(bookReviewDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllReviews")
    public ResponseEntity<Page<BookReview>> getAllBookReviews(@RequestParam(name = "page")int page,
                                                          @RequestParam(name = "size")int size){
        Page<BookReview> reviews = bookReviewService.getAllBookReviews(page,size);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteReview/{reviewId}")
    public ResponseEntity<String> deleteBookReviewById(@PathVariable String reviewId){
        bookReviewService.deleteBookReviewById(reviewId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(REVIEW_DELETED);
    }
}
