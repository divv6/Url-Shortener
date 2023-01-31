package com.example.urlshortener.infrastructure;

public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}
