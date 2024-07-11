package com.larcangeli.monolith.core.domain.factory.impl;

import com.larcangeli.monolith.core.domain.entities.RecommendationEntity;
import com.larcangeli.monolith.core.domain.factory.IRecommendationFactory;
import com.larcangeli.monolith.core.interfaces.IRecommendationEntity;

public class RecommendationFactory implements IRecommendationFactory {
    @Override
    public IRecommendationEntity createRecommendation(Integer version, String author, String content) {
        return new RecommendationEntity(version,author,content);
    }
}
