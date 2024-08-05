package com.larcangeli.monolith.review.domain;

import com.larcangeli.monolith.review.IReviewService;
import com.larcangeli.monolith.review.ReviewDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class ReviewService implements IReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public ReviewDTO save(ReviewDTO review) {
        return reviewMapper.reviewToReviewDTO(reviewRepository.save(reviewMapper.reviewDTOToReview(review)));
    }

    @Override
    public void deleteById(Long reviewId) {
        if(reviewRepository.findById(reviewId).isPresent())
           reviewRepository.deleteById(reviewId);
        else throw ReviewNotFoundException.forId(reviewId);
    }

    @Override
    public void deleteReviews(Long productId) {
        reviewRepository.deleteAll(reviewRepository.findRecommendationsByProductId(productId));
    }


    @Override
    public List<ReviewDTO> findReviewsByProductId(Long productId) {
        return reviewMapper.reviewsToReviewDTOs(reviewRepository.findRecommendationsByProductId(productId));
    }
}
