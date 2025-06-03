package com.nathan.url_shortener.repository;

import com.nathan.url_shortener.domain.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {
    Url findByShortUrl(String code);
}
