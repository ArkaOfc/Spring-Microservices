package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.web.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;
import com.larcangeli.monolith.core.entity.implementation.ProductEntity;
import com.larcangeli.monolith.core.usecase.boundaries.input.RemovalInputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.output.RemovalOutputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.output.RetrievalOutputBoundary;

/**
 * A simple use case that implements the logic of deleting entities
 */
public class RemovalInteractor implements RemovalInputBoundary {

    RemovalOutputBoundary removalOutputBoundary;

    public RemovalInteractor(RemovalOutputBoundary removalOutputBoundary) {
        this.removalOutputBoundary = removalOutputBoundary;
    }

    @Override
    public void deleteProduct(Long productId) {
        removalOutputBoundary.deleteProduct(productId);
    }

    @Override
    public void deleteRecommendation(Long recommendationId) {
        removalOutputBoundary.deleteRecommendation(recommendationId);
    }

    @Override
    public void deleteReview(Long reviewId) {
        removalOutputBoundary.deleteReview(reviewId);
    }
}
