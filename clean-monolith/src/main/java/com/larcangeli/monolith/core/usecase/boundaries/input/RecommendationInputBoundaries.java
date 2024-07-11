package com.larcangeli.monolith.core.usecase.boundaries.input;

import com.larcangeli.monolith.adapters.web.mapper.dto.RecommendationDTO;

/**
 * A simple boundary that allows the Controller in the adapter layer to use all the functions related to a Recommendation
 * without a direct interaction with the Use Case layer
 */
public interface RecommendationInputBoundaries {

    RecommendationDTO createRecommendation(RecommendationDTO recommendationDTO);

    void deleteRecommendation(Long recommendationId);

}
