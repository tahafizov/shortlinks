package com.example.shortlinks.controllers;

import com.example.shortlinks.dto.RequestOriginalLink;
import com.example.shortlinks.dto.ResponseShortLink;
import com.example.shortlinks.service.GetLinkService;
import com.example.shortlinks.service.impl.PrefixShortLink;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LinkConroller {
    private final GetLinkService shortLinkService;
    private final PrefixShortLink prefixShortLink;

    @PostMapping("/generate")
    public ResponseShortLink generate(@RequestBody RequestOriginalLink requestOriginalLink) {
        String shortLink = shortLinkService.generateShortLink(requestOriginalLink.getOriginal());
        return ResponseShortLink.builder().link(prefixShortLink.addPrefix(shortLink)).build();
    }

    @GetMapping("/l/{some-short-name}")
    public ResponseEntity<Void> redirectToOriginalLink(@PathVariable("some-short-name") String shortLink) {
        String originalLink = shortLinkService.getOriginalLink(shortLink);
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.LOCATION, originalLink)
                .build();
    }
}
