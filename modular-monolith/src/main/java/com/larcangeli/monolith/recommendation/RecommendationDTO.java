package com.larcangeli.monolith.recommendation;

public record RecommendationDTO(Long recommendationId,
                                Long productId,
                                Integer version,
                                String author,
                                int rating,
                                String content){
}
