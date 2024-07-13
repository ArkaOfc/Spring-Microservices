package com.larcangeli.monolith.core.usecase.boundaries.input;

import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.RecommendationDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;

/**
 * A simple boundary that allows the Controller in the adapter layer to use all the underlying functions
 * without a direct interaction with the Use Case layer
 */
public interface CreationInputBoundary {
    ProductAggregateDTO createProduct(ProductAggregateDTO productAggregateDTO);

    RecommendationDTO createRecommendation(RecommendationDTO recommendationDTO);

    ReviewDTO createReview(ReviewDTO review);
}
