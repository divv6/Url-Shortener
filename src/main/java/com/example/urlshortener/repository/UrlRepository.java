package com.example.urlshortener.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends CrudRepository<Url, Long> {

    Optional<Url> findByShortUrl(String shortUrl);
}
