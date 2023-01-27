package com.bookdekho.application.repository;

import com.bookdekho.application.model.AboutBook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutBookRepository extends MongoRepository<AboutBook, String> {
}
