package com.nathan.url_shortener.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Url {
    @Id
    private String id;
    private String originalUrl;
    private String shortUrl;

    public Url(String originalUrl, String shortUrl) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortUrl;
    }
}
