package com.nathan.url_shortener.controller;

import com.nathan.url_shortener.domain.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nathan.url_shortener.service.UrlService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/shorten")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public ResponseEntity<Url> shortenUrl(@RequestBody Url originalUrl){
        Url newUrl = urlService.shortenUrl(originalUrl.getOriginalUrl());

        return ResponseEntity.status(200).body(newUrl);
    }

    @GetMapping
    public ResponseEntity<List<Url>> getAll(){
        List<Url> listaUrls = urlService.getAll();

        return listaUrls.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(listaUrls);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Url> getUrl(@PathVariable String shortUrl){
        String originalUrl = urlService.getUrl(shortUrl);

        return ResponseEntity.status(301)
                .location(URI.create(originalUrl))
                .build();

    }
}
