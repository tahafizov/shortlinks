package com.example.shortlinks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseStatsLink {
    private String link;
    private String original;
    private Long rank;
    private Long count;
}
