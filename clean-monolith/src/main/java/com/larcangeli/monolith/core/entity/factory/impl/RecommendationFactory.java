package com.larcangeli.monolith.core.entity.factory.impl;

import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.factory.IRecommendationFactory;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
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
