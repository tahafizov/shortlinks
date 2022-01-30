package com.example.shortlinks.service;

import com.example.shortlinks.dto.ResponseStatsLink;

import java.util.List;

public interface StatsService {
    ResponseStatsLink getStatsByShortLink(String shortLink);
    List<ResponseStatsLink> getStatsByPage(int page, int count);
}
