package com.bookdekho.application.serviceimpl;

import com.bookdekho.application.dto.ReaderDTO;
import com.bookdekho.application.exception.EntityNotFoundException;
import com.bookdekho.application.model.Reader;
import com.bookdekho.application.repository.ReaderRepository;
import com.bookdekho.application.service.ReaderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public ReaderDTO addReader(ReaderDTO readerDTO) {
        Reader reader = new Reader();
        BeanUtils.copyProperties(readerDTO, reader);
        readerRepository.save(reader);
        BeanUtils.copyProperties(reader, readerDTO);
        return readerDTO;
    }

    @Override
    public ReaderDTO updateReader(ReaderDTO readerDTO) {
        Reader reader = readerRepository.findById(readerDTO.getId()).orElseThrow(EntityNotFoundException:: new);
        BeanUtils.copyProperties(readerDTO,reader);
        readerRepository.save(reader);
        BeanUtils.copyProperties(reader, reader);
        return readerDTO;
    }

    @Override
    public ReaderDTO getReaderById(String readerId) {
        Reader reader = readerRepository.findById(readerId).orElseThrow(EntityNotFoundException :: new);
        ReaderDTO readerDTO = new ReaderDTO();
        BeanUtils.copyProperties(reader, readerDTO);
        return readerDTO;
    }

    @Override
    public Page<Reader> getAllReaders(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return readerRepository.findAll(pageable);
    }

    @Override
    public void deleteReaderById(String readerId) {
        readerRepository.deleteById(readerId);
    }
}