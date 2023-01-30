package com.example.urlshortener.controller;

import com.example.urlshortener.model.LongUrlRequest;
import com.example.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private UrlService urlService;

    @PostMapping("api/create-short")
    public String toShortUrl(@RequestBody LongUrlRequest longUrlRequest) {
        return urlService.toShortUrl(longUrlRequest);
    }
}
