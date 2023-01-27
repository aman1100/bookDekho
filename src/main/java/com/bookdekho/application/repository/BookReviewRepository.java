package com.bookdekho.application.repository;

import com.bookdekho.application.model.BookReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewRepository extends MongoRepository<BookReview, String> {
}
