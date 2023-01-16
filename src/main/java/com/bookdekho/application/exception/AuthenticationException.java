package com.bookdekho.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AuthenticationException extends RuntimeException{
    public AuthenticationException(){
        this("Issue in Authentication");
    }
    public AuthenticationException(String message) {
        this(message, null);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
