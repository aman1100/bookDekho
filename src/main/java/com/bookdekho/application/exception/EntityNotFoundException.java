package com.bookdekho.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{
    @ExceptionHandler
    public String exceptionHandler(EntityNotFoundException enf){
        return "User Not Found : " + enf.getMessage();
    }
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
