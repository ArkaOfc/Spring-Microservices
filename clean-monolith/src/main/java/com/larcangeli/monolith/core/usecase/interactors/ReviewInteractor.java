package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;
import com.larcangeli.monolith.core.usecase.boundaries.input.ReviewInputBoundaries;

/**
 * A simple use case that implements the logic of saving and deleting a Review
 */
public class ReviewInteractor implements ReviewInputBoundaries {
    @Override
    public ReviewDTO createReview(ReviewDTO review) {
        return null;
    }

    @Override
    public void deleteReview(Long reviewId) {

    }
}
