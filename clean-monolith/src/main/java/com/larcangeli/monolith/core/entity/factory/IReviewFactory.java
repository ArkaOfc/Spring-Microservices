package com.larcangeli.monolith.core.entity.factory;

import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;

public interface IReviewFactory {
    IReviewEntity createReview(String author, String subject, String content);
}
