package com.bookdekho.application.service;

import com.bookdekho.application.dto.AboutBookDTO;
import com.bookdekho.application.model.AboutBook;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AboutBookService {
    AboutBookDTO addBook(AboutBookDTO aboutBookDTO);

    AboutBookDTO updateBook(AboutBookDTO aboutBookDTO);

    AboutBookDTO getBookById(String bookId);

    Page<AboutBook> getAllBooks(int page, int size);

    void deleteBookById(String bookId);
}
