package com.larcangeli.monolith.adapters.web.mapper.dto;

public record RecommendationDTO(Long recommendationId, Long productId, Integer version, String author, int rating, String content){
}
