package com.bookdekho.application.serviceimpl;

import com.bookdekho.application.dto.AboutBookDTO;
import com.bookdekho.application.exception.EntityNotFoundException;
import com.bookdekho.application.model.AboutBook;
import com.bookdekho.application.repository.AboutBookRepository;
import com.bookdekho.application.service.AboutBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class AboutBookServiceImpl implements AboutBookService {

    @Autowired
    private AboutBookRepository aboutBookRepository;

    @Override
    public AboutBookDTO addBook(AboutBookDTO aboutBookDTO) {
        AboutBook aboutBook = new AboutBook();
        BeanUtils.copyProperties(aboutBookDTO,aboutBook);
        aboutBookRepository.save(aboutBook);
        BeanUtils.copyProperties(aboutBook,aboutBookDTO);
        return aboutBookDTO;
    }


    @Override
    public AboutBookDTO updateBook(AboutBookDTO aboutBookDTO) {
        AboutBook aboutBook = aboutBookRepository.findById(aboutBookDTO.getId()).orElseThrow(EntityNotFoundException:: new);
        BeanUtils.copyProperties(aboutBookDTO,aboutBook);
        aboutBookRepository.save(aboutBook);
        BeanUtils.copyProperties(aboutBook, aboutBookDTO);
        return aboutBookDTO;
    }

    @Override
    public AboutBookDTO getBookById(String bookId) {
        AboutBook aboutBook = aboutBookRepository.findById(bookId).orElseThrow(EntityNotFoundException :: new);
        AboutBookDTO aboutBookDTO = new AboutBookDTO();
        BeanUtils.copyProperties(aboutBook, aboutBookDTO);
        return aboutBookDTO;
    }

    @Override
    public Page<AboutBook> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return aboutBookRepository.findAll(pageable);
    }

    @Override
    public void deleteBookById(String bookId) {
        aboutBookRepository.deleteById(bookId);
    }

}
