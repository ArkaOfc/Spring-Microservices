package com.larcangeli.monolith.core.entity.implementation;

import com.larcangeli.monolith.core.entity.interfaces.IReviewFactory;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;
import org.springframework.stereotype.Component;

@Component
public class ReviewFactory implements IReviewFactory {
    @Override
    public IReviewEntity createReview(String author, String subject, String content) {
        return new ReviewEntity(author, subject, content);
    }
    @Override
    public IReviewEntity createReview(Long productId, String author, String subject, String content) {
        return new ReviewEntity(productId, author, subject, content);
    }

    @Override
    public IReviewEntity createReview(Long reviewId, Long productId, String author, String subject, String content) {
        return new ReviewEntity(reviewId, productId, author, subject, content);
    }
}
