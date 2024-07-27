package com.larcangeli.monolith.core.usecase.boundaries.input;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;

/**
 * A simple boundary that allows the Controller in the adapter layer to use all the underlying functions
 * without a direct interaction with the Use Case layer
 */
public interface CreationInputBoundary {
    IProductEntity createProduct(IProductEntity productAggregateDTO);

    IRecommendationEntity createRecommendation(IRecommendationEntity recommendationDTO);

    IReviewEntity createReview(IReviewEntity review);
}
