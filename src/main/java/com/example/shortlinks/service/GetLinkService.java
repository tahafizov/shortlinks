package com.example.shortlinks.service;

public interface GetLinkService {
    String generateShortLink(String originalLink);
    String getOriginalLink(String shortLink);
}
