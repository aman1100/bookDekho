package com.bookdekho.application.service;

import com.bookdekho.application.dto.BookReviewDTO;
import com.bookdekho.application.model.BookReview;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface BookReviewService {
    BookReviewDTO addBookReview(BookReviewDTO bookReviewDTO);

    BookReviewDTO updateBookReview(BookReviewDTO bookReviewDTO);

    BookReviewDTO getBookReviewById(String bookReviewId);

    Page<BookReview> getAllBookReviews(int page, int size);

    void deleteBookReviewById(String reviewId);
}
