package com.larcangeli.monolith.core.domain.factory;

import com.larcangeli.monolith.core.interfaces.IReviewEntity;

public interface IReviewFactory {
    IReviewEntity createReview(String author, String subject, String content);
}
