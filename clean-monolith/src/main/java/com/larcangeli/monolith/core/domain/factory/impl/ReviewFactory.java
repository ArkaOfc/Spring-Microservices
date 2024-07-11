package com.larcangeli.monolith.core.domain.factory.impl;

import com.larcangeli.monolith.core.domain.entities.ReviewEntity;
import com.larcangeli.monolith.core.domain.factory.IReviewFactory;
import com.larcangeli.monolith.core.interfaces.IReviewEntity;

public class ReviewFactory implements IReviewFactory {
    @Override
    public IReviewEntity createReview(String author, String subject, String content) {
        return new ReviewEntity(author, subject, content);
    }
}
