package com.larcangeli.monolith.core.entity.interfaces;

public interface IRecommendationFactory {
    IRecommendationEntity createRecommendation(Long productId, String author, int rating, String content);
    IRecommendationEntity createRecommendation(Long productId, Integer version, String author, int rating, String content);
}
