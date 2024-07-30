package com.larcangeli.monolith.core.entity.interfaces;

public interface IRecommendationFactory {
    IRecommendationEntity createRecommendation(Integer version, String author, int rating, String content);
    IRecommendationEntity createRecommendation(Long productId, Integer version, String author, int rating, String content);
    IRecommendationEntity createRecommendation(Long id, Long productId, Integer version, String author, int rating, String content);


}
