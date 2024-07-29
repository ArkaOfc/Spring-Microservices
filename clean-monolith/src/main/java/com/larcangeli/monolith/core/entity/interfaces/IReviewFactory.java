package com.larcangeli.monolith.core.entity.interfaces;

public interface IReviewFactory {
    IReviewEntity createReview(Long productId, String author, String subject, String content);
}
