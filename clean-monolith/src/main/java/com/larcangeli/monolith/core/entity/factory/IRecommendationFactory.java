package com.larcangeli.monolith.core.entity.factory;

import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;

public interface IRecommendationFactory {
    IRecommendationEntity createRecommendation(Integer version, String author, String content);
}
