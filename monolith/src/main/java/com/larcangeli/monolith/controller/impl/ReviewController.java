package com.larcangeli.monolith.controller.impl;

import com.larcangeli.monolith.controller.IReviewController;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.persistence.model.Review;
import com.larcangeli.monolith.service.IRecommendationService;
import com.larcangeli.monolith.service.IReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
@RestController
public class ReviewController implements IReviewController {

    IReviewService reviewService;

    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public Review findById(Long review_id) {
        return reviewService.findById(review_id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
    }

    @Override
    public Collection<Review> findAll() {
        return reviewService.findAll();
    }

    @Override
    public Review create(Review review) {
        return reviewService.save(review);
    }
}
