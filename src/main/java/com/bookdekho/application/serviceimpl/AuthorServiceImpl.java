package com.bookdekho.application.serviceimpl;

import com.bookdekho.application.dto.AuthorDTO;
import com.bookdekho.application.exception.EntityNotFoundException;
import com.bookdekho.application.model.Author;
import com.bookdekho.application.repository.AuthorRepository;
import com.bookdekho.application.service.AuthorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDTO addAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDTO,author);
        authorRepository.save(author);
        BeanUtils.copyProperties(author,authorDTO);
        return authorDTO;
    }

    @Override
    public AuthorDTO updateAuthor(String authorId, AuthorDTO authorDTO) {
        Author author = authorRepository.findById(authorId).orElseThrow(EntityNotFoundException:: new);
        BeanUtils.copyProperties(authorDTO,author);
        authorRepository.save(author);
        BeanUtils.copyProperties(author, authorDTO);
        return authorDTO;
    }

    @Override
    public AuthorDTO getAuthorById(String authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(EntityNotFoundException :: new);
        AuthorDTO authorDTO = new AuthorDTO();
        BeanUtils.copyProperties(author, authorDTO);
        return authorDTO;
    }

    @Override
    public Page<Author> getAllAuthors(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return authorRepository.findAll(pageable);
    }

    @Override
    public void deleteAuthorById(String authorId) {
        authorRepository.deleteById(authorId);
    }

}
