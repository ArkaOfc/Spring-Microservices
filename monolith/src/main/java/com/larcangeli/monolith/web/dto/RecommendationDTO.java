package com.larcangeli.monolith.web.dto;

public record RecommendationDTO(
        Long recommendationId,
        Integer version,
        String author,
        int rating,
        String content){
}
