package com.example.shortlinks.service;

public interface EncodeDecodeService {
    String encode(Long number);
    Long decode(String shortLink);
}
