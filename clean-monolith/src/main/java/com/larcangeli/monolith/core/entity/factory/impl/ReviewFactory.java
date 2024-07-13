package com.larcangeli.monolith.core.entity.factory.impl;

import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;
import com.larcangeli.monolith.core.entity.factory.IReviewFactory;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;

public class ReviewFactory implements IReviewFactory {
    @Override
    public IReviewEntity createReview(Long productId, String author, String subject, String content) {
        return new ReviewEntity(productId, author, subject, content);
    }
}
