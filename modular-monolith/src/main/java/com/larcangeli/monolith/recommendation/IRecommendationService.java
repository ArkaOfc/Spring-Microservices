package com.larcangeli.monolith.recommendation;

import java.util.List;

public interface IRecommendationService {
    RecommendationDTO save(RecommendationDTO recommendation);

    void deleteById(Long recommendationId);

    void deleteRecommendations(Long productId);

    List<RecommendationDTO> findRecommendationsByProductId(Long productId);
}
