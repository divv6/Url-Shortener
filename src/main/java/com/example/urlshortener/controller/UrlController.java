package com.example.urlshortener.controller;

import com.example.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/api/create-short")
    public String toShortUrl(@RequestParam String url, @RequestParam(required = false) String expiryDate) {
        return urlService.toShortUrl(url, expiryDate);
    }

    @RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
    public ResponseEntity<Void> redirectToLongUrl(@PathVariable String shortUrl) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(urlService.toLongUrl(shortUrl)))
                .build();
    }
}
