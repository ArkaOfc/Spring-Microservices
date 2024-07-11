package com.larcangeli.monolith.core.usecase.boundaries.input;

import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;

/**
 * A simple boundary that allows the Controller in the adapter layer to use all the functions related to a Review
 * without a direct interaction with the Use Case layer
 */
public interface ReviewInputBoundaries {

    ReviewDTO createReview(ReviewDTO review);

    void deleteReview(Long reviewId);

}
