package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.web.mapper.dto.RecommendationDTO;
import com.larcangeli.monolith.core.usecase.boundaries.input.RecommendationInputBoundaries;

/**
 * A simple use case that implements the logic of saving and deleting a Recommendation
 */
public class RecommendationInteractor implements RecommendationInputBoundaries {
    @Override
    public RecommendationDTO createRecommendation(RecommendationDTO recommendationDTO) {
        return null;
    }

    @Override
    public void deleteRecommendation(Long recommendationId) {

    }
}
