package com.bookdekho.application.service;

import com.bookdekho.application.dto.AuthorDTO;
import com.bookdekho.application.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    AuthorDTO addAuthor(AuthorDTO authorDTO);

    AuthorDTO updateAuthor(AuthorDTO authorDTO);

    AuthorDTO getAuthorById(String authorId);

    Page<Author> getAllAuthors(int page, int size);

    void deleteAuthorById(String authorId);

}
