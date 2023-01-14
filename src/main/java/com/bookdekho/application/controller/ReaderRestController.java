package com.bookdekho.application.controller;

import com.bookdekho.application.dto.ReaderDTO;
import com.bookdekho.application.model.Reader;
import com.bookdekho.application.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reader")
public class ReaderRestController {

    @Autowired
    private ReaderService readerService;
    private static final String READER_DELETED = "Reader Deleted";

    @PostMapping(value = "/addReader")
    public ResponseEntity<ReaderDTO> addReader(@RequestBody ReaderDTO readerDTO){
        readerDTO = readerService.addReader(readerDTO);
        return new ResponseEntity<>(readerDTO, HttpStatus.OK);
    }

    @PatchMapping(value = "/updateReader/{id}")
    public ResponseEntity<ReaderDTO> updateReader(@PathVariable String readerId, @RequestBody ReaderDTO readerDTO){
        readerDTO = readerService.updateReader(readerId, readerDTO);
        return new ResponseEntity<>(readerDTO, HttpStatus.OK);
    }
    @GetMapping(value = "getReader/{id}")
    public ResponseEntity<ReaderDTO> getReaderById(@PathVariable String readerId){
        ReaderDTO readerDTO = readerService.getReaderById(readerId);
        return new ResponseEntity<>(readerDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllReaders")
    public ResponseEntity<Page<Reader>> getAllReaders(@RequestParam(name = "page")int page,
                                                      @RequestParam(name = "size")int size){
        Page<Reader> readers = readerService.getAllReaders(page,size);
        return new ResponseEntity<>(readers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteReader/{id}")
    public ResponseEntity<String> deleteReader(@PathVariable String readerId){
        readerService.deleteReaderById(readerId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(READER_DELETED);
    }

}
