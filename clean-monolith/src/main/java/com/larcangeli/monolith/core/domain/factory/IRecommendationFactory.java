package com.larcangeli.monolith.core.domain.factory;

import com.larcangeli.monolith.core.interfaces.IRecommendationEntity;

public interface IRecommendationFactory {
    IRecommendationEntity createRecommendation(Integer version, String author, String content);
}
