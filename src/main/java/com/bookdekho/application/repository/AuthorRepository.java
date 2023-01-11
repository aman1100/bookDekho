package com.bookdekho.application.repository;

import com.bookdekho.application.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Boolean existsByEmail(String email);
}
