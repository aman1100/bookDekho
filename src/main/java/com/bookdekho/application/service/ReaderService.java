package com.bookdekho.application.service;

import com.bookdekho.application.dto.ReaderDTO;
import com.bookdekho.application.model.Reader;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ReaderService {
    ReaderDTO addReader(ReaderDTO readerDTO);

    ReaderDTO updateReader(ReaderDTO readerDTO);

    ReaderDTO getReaderById(String readerId);

    Page<Reader> getAllReaders(int page, int size);

    void deleteReaderById(String readerId);
}

