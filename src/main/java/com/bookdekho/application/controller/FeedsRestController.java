package com.bookdekho.application.controller;

import com.bookdekho.application.model.BookReview;
import com.bookdekho.application.model.SearchParameters;
import com.bookdekho.application.service.BookReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feeds")
public class FeedsRestController {

    @Autowired
    private BookReviewService bookReviewService;

    @GetMapping
    public Page<BookReview> getFeeds(@RequestBody SearchParameters searchParameters,
                                     Pageable pageable){
        return bookReviewService.getFeeds(searchParameters, pageable);
    }
}
