package com.nathan.url_shortener.service;

import com.nathan.url_shortener.domain.Url;
import com.nathan.url_shortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Url shortenUrl(String originalUrl){
        String shortCode = UUID.randomUUID().toString().substring(0, 8);

        Url novaUrl = new Url(originalUrl, shortCode);

        urlRepository.save(novaUrl);

        return  novaUrl;
    }

    public List<Url> getAll(){
        return urlRepository.findAll();
    }

    public String getUrl(String urlCurta){
        Url url = urlRepository.findByShortUrl(urlCurta);

        return url.getOriginalUrl();
    }
}
