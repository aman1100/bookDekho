package com.bookdekho.application.serviceimpl;

import com.bookdekho.application.dto.BookReviewDTO;
import com.bookdekho.application.exception.EntityNotFoundException;
import com.bookdekho.application.model.BookReview;
import com.bookdekho.application.repository.BookReviewRepository;
import com.bookdekho.application.service.BookReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class BookReviewServiceImpl implements BookReviewService {

    @Autowired
    private BookReviewRepository bookReviewRepository;

    @Override
    public BookReviewDTO addBookReview(BookReviewDTO bookReviewDTO) {
        BookReview bookReview = new BookReview();
        BeanUtils.copyProperties(bookReviewDTO,bookReview);
        bookReviewRepository.save(bookReview);
        BeanUtils.copyProperties(bookReview,bookReviewDTO);
        return bookReviewDTO;
    }


    @Override
    public BookReviewDTO updateBookReview(BookReviewDTO bookReviewDTO) {
        BookReview bookReview = bookReviewRepository.findById(bookReviewDTO.getId()).orElseThrow(EntityNotFoundException:: new);
        BeanUtils.copyProperties(bookReviewDTO,bookReview);
        bookReviewRepository.save(bookReview);
        BeanUtils.copyProperties(bookReview, bookReviewDTO);
        return bookReviewDTO;
    }

    @Override
    public BookReviewDTO getBookReviewById(String bookReviewId) {
        BookReview bookReview = bookReviewRepository.findById(bookReviewId).orElseThrow(EntityNotFoundException :: new);
        BookReviewDTO bookReviewDTO = new BookReviewDTO();
        BeanUtils.copyProperties(bookReview, bookReviewDTO);
        return bookReviewDTO;
    }

    @Override
    public Page<BookReview> getAllBookReviews(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return bookReviewRepository.findAll(pageable);
    }

    @Override
    public void deleteBookReviewById(String bookReviewId) {
        bookReviewRepository.deleteById(bookReviewId);
    }

}
