package com.larcangeli.monolith.core.entity.interfaces;

import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;

import java.util.Set;

public interface IProductEntity {
    Long getProductId();
    Integer getVersion();
    String getName();
    int getWeight();
    Set<ReviewEntity> getReviews();
    Set<RecommendationEntity> getRecommendations();
}
