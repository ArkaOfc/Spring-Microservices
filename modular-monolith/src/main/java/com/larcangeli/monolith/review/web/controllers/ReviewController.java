package com.larcangeli.monolith.review.web.controllers;

import com.larcangeli.monolith.review.shared.ReviewDTO;
import com.larcangeli.monolith.review.shared.IReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class ReviewController {

    private static final Logger LOG = LoggerFactory.getLogger(ReviewController.class);

    private final IReviewService reviewService;

    @Autowired
    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping(value = "/product-composite/review", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ReviewDTO createReview(@RequestBody ReviewDTO review){
        LOG.debug("deleteCompositeProduct: Creates the review with ID: {}", review.reviewId());

        try{
            ReviewDTO r = reviewService.save(review);
            LOG.debug("deleteCompositeProduct: review created with ID: {}", review.reviewId());
            return r;
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Review with ID: " + review.reviewId() + " not found");
        }
    }

    @DeleteMapping(value = "/product-composite/review/{reviewId}")
    void deleteReview(@PathVariable Long reviewId){
        LOG.debug("deleteCompositeProduct: Deletes the review with ID: {}", reviewId);

        try{
            reviewService.deleteById(reviewId);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Review with ID: " + reviewId + " not found");
        }
        LOG.debug("deleteCompositeProduct: review deleted for ID: {}", reviewId);

    }

}
