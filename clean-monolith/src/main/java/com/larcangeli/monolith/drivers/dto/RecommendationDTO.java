package com.larcangeli.monolith.drivers.dto;

public record RecommendationDTO(Long recommendationId,
                                Long productId,
                                Integer version,
                                String author,
                                int rating,
                                String content){
}
