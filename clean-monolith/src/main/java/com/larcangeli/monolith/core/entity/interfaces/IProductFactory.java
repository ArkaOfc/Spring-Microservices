package com.larcangeli.monolith.core.entity.interfaces;


import java.util.Set;

public interface IProductFactory {
    IProductEntity createProduct(Integer version, String name, int weight);
    IProductEntity createProduct(Integer version, String name, int weight, Set<IRecommendationEntity> recommendations, Set<IReviewEntity> reviews);
}
