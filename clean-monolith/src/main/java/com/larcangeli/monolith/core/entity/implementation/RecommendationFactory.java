package com.larcangeli.monolith.core.entity.implementation;

import com.larcangeli.monolith.core.entity.interfaces.IRecommendationFactory;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;

public class RecommendationFactory implements IRecommendationFactory {
    @Override
    public IRecommendationEntity createRecommendation(Long productId, String author, int rating, String content) {
        return new RecommendationEntity(productId,author,rating,content);
    }
    @Override
    public IRecommendationEntity createRecommendation(Long productId, Integer version, String author, int rating, String content) {
        return new RecommendationEntity(productId,version,author,rating,content);
    }
}
