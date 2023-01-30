package com.example.urlshortener.service;

import com.example.urlshortener.model.LongUrlRequest;
import com.example.urlshortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {

    private UrlRepository urlRepository;

    public String toShortUrl(LongUrlRequest longUrlRequest) {

        return "";
    }

}
