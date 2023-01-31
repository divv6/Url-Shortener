package com.example.urlshortener.controller;

import com.example.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/api/create-short")
    public String toShortUrl(@RequestParam String url, @RequestParam(required = false) String expiryDate) {
        return urlService.toShortUrl(url, expiryDate);
    }
}
