package com.larcangeli.monolith.core.usecase.boundaries.input;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;
import com.larcangeli.monolith.core.usecase.DTO.ProductAggregateDTO;
import com.larcangeli.monolith.core.usecase.DTO.RecommendationDTO;
import com.larcangeli.monolith.core.usecase.DTO.ReviewDTO;

/**
 * A simple boundary that allows the Controller in the adapter layer to use all the underlying functions
 * without a direct interaction with the Use Case layer
 */
public interface CreationInputBoundary {
    ProductAggregateDTO createProduct(ProductAggregateDTO product);

    RecommendationDTO createRecommendation(RecommendationDTO recommendation);

    ReviewDTO createReview(ReviewDTO review);
}
