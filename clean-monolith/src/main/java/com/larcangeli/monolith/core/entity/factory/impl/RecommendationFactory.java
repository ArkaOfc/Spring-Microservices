package com.larcangeli.monolith.core.entity.factory.impl;

import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.factory.IRecommendationFactory;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;

public class RecommendationFactory implements IRecommendationFactory {
    @Override
    public IRecommendationEntity createRecommendation(Integer version, String author, String content) {
        return new RecommendationEntity(version,author,content);
    }
}
