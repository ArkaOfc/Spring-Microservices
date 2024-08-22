package com.larcangeli.monolith.review.domain;

import com.larcangeli.monolith.review.shared.IReviewService;
import com.larcangeli.monolith.review.shared.ReviewDTO;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class ReviewService implements IReviewService {

    private final ReviewRepository repo;
    private final ReviewMapper mapper;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.repo = reviewRepository;
        this.mapper = reviewMapper;
    }

    @Override
    public ReviewDTO save(ReviewDTO review) {
        return mapper.toDTO(repo.save(mapper.toEntity(review)));
    }

    @Override
    public void saveReviewOnProductCreation(ReviewDTO review) {
        repo.save(mapper.toEntity(review));
    }

    @Override
    public void deleteById(Long reviewId) {
        if(repo.findById(reviewId).isPresent())
           repo.deleteById(reviewId);
        else throw ReviewNotFoundException.forId(reviewId);
    }

    @Override
    public void deleteReviews(Long productId) {
        repo.deleteAll(repo.findRecommendationsByProductId(productId));
    }


    @Override
    public List<ReviewDTO> findReviewsByProductId(Long productId) {
        return mapper.toDTOs(repo.findRecommendationsByProductId(productId));
    }
}
