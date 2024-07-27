package com.larcangeli.monolith.core.entity.implementation;

import com.larcangeli.monolith.core.entity.interfaces.IProductFactory;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;

import java.util.Set;

public class ProductFactory implements IProductFactory {
    @Override
    public IProductEntity createProduct(Integer version, String name, int weight) {
        return new ProductEntity(version,name,weight);
    }

    @Override
    public IProductEntity createProduct(Integer version, String name, int weight, Set<IRecommendationEntity> recommendations, Set<IReviewEntity> reviews) {
        return new ProductEntity(version,name,weight,recommendations,reviews);
    }
}
