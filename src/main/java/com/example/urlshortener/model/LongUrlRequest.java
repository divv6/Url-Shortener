package com.example.urlshortener.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LongUrlRequest {

    private String url;
    private LocalDate expiryDate;
}
