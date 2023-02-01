package com.example.urlshortener.controller;

import com.example.urlshortener.service.UrlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@Tag(name = "Url Controller", description = "Shortening URL and getting original URL")
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/api/create-short")
    @Operation(summary = "Getting short link")
    public String toShortUrl(@RequestParam String url, @RequestParam(required = false) String expiryDate) {
        return urlService.toShortUrl(url, expiryDate);
    }

    @RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
    @Operation(summary = "Getting original link")
    public ResponseEntity<Void> redirectToLongUrl(@PathVariable String shortUrl) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(urlService.toLongUrl(shortUrl)))
                .build();
    }
}
