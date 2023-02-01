package com.example.urlshortener.infrastructure;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<String> handle(CustomException e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
