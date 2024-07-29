package com.larcangeli.monolith.core.entity.interfaces;

import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;

import java.util.Set;

public interface IProductEntity {
    Long getId();
    Integer getVersion();
    String getName();
    int getWeight();
    Set<IReviewEntity> getReviews();
    Set<IRecommendationEntity> getRecommendations();
}
