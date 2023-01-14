package com.bookdekho.application.repository;

import com.bookdekho.application.model.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends MongoRepository<Reader, String> {
}
