package com.bookdekho.application.serviceimpl;

import com.bookdekho.application.dto.BookReviewDTO;
import com.bookdekho.application.exception.EntityNotFoundException;
import com.bookdekho.application.model.BookReview;
import com.bookdekho.application.model.SearchParameters;
import com.bookdekho.application.repository.BookReviewRepository;
import com.bookdekho.application.service.BookReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookReviewServiceImpl implements BookReviewService {

    private static final String BOOK_NAME = "bookName";
    private static final String GENRE = "genre";
    private static final String REVIEW_IN_STARS = "reviewInStars";
    private static final String BOOK_VERSION = "bookVersion";
    private static final String AUTHOR_NAME = "authorName";

    @Autowired
    private BookReviewRepository bookReviewRepository;

    @Autowired
    private MongoOperations mongoOperations;

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

    @Override
    public Page<BookReview> getFeeds(SearchParameters searchParameters, Pageable pageable) {
        List<Criteria> criteriaList = new ArrayList<>();
        if(searchParameters != null){
            if(searchParameters.getBookName() != null && !searchParameters.getBookName().isEmpty())
                criteriaList.add(Criteria.where(BOOK_NAME).is(searchParameters.getBookName()));
            if(searchParameters.getGenre() != null && !searchParameters.getGenre().isEmpty())
                criteriaList.add(Criteria.where(GENRE).in(searchParameters.getGenre()));
            if(searchParameters.getStar() != null)
                criteriaList.add(Criteria.where(REVIEW_IN_STARS).is(searchParameters.getStar()));
            if(searchParameters.getBookVersions() != null && !searchParameters.getBookVersions().isEmpty())
                criteriaList.add(Criteria.where(BOOK_VERSION).in(searchParameters.getBookVersions()));
            if(searchParameters.getAuthorName() != null && !searchParameters.getAuthorName().isEmpty())
                criteriaList.add(Criteria.where(AUTHOR_NAME).is(searchParameters.getAuthorName()));

            Query query = new Query();
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0]))).with(pageable);

            List<BookReview> bookReviews = mongoOperations.find(query, BookReview.class);
            long count = mongoOperations.count(query, BookReview.class);

            return new PageImpl<>(bookReviews,pageable, count);
        }
        return null;
    }

}
