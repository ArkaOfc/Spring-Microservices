package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.core.usecase.boundaries.input.RemovalInputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.output.RemovalOutputBoundary;
import org.springframework.stereotype.Component;

/**
 * A simple use case that implements the logic of deleting entities
 */
@Component
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
