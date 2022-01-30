package com.example.shortlinks.service.impl;

import com.example.shortlinks.repository.LinkRepository;
import com.example.shortlinks.service.EncodeDecodeService;
import com.example.shortlinks.service.GetLinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class GetLinkServiceImpl implements GetLinkService {

    private final LinkRepository linkRepository;
    private final EncodeDecodeService encodeDecodeService;

    @Override
    public String generateShortLink(String originalLink) {

        String shortLink = linkRepository.getShortLink(originalLink);
        if (shortLink != null) {
            return shortLink;
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        shortLink = encodeDecodeService.encode(timestamp.getTime());
        linkRepository.saveLink(originalLink, shortLink);
        return shortLink;
    }

    @Override
    public String getOriginalLink(String shortLink) {
        return linkRepository.getOriginalLink(shortLink, false);
    }
}
