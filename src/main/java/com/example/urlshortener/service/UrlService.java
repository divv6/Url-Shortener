package com.example.urlshortener.service;

import com.example.urlshortener.infrastructure.CustomException;
import com.example.urlshortener.model.LongUrlRequest;
import com.example.urlshortener.repository.Url;
import com.example.urlshortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public String toShortUrl(String url, String expiryDate) {

        try{
            new URL(url).toURI();
        }
        catch (URISyntaxException exception) {
            throw new CustomException("Wrong URL");
        }
        catch (MalformedURLException exception) {
            throw new CustomException("Wrong URI");
        }

        LocalDate expdate = null;

        if(expiryDate != null) {
            expdate = LocalDate.parse(expiryDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            if (expdate.isBefore(LocalDate.now())) {
                throw new CustomException("Expiry date can not be earlier than today");
            }
        }

        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int a = (int) (Math.random() * 9);
            shortUrl.append(a);
        }

        Url urlobject = Url.builder()
                .longUrl(url)
                .shortUrl(shortUrl.toString())
                .created(LocalDate.now())
                .expiryDate(expdate)
                .build();

        urlRepository.save(urlobject);

        return shortUrl.toString();
    }

}
