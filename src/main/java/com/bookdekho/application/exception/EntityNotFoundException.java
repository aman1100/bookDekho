package com.bookdekho.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(){
        this("Entity Representation Model not found!");
    }
    public EntityNotFoundException(String message) {
        this(message, null);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
