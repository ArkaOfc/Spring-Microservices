package com.larcangeli.monolith.core.entity.factory;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;

import java.util.Set;

public interface IProductFactory {
    IProductEntity createProduct(Integer version, String name, int weight);
    IProductEntity createProduct(Integer version, String name, int weight, Set<IRecommendationEntity> recommendations, Set<IReviewEntity> reviews);
}
