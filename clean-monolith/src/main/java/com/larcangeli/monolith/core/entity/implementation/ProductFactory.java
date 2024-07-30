package com.larcangeli.monolith.core.entity.implementation;

import com.larcangeli.monolith.core.entity.interfaces.IProductFactory;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductFactory implements IProductFactory {
    /*@Override
    public IProductEntity createProduct(Long productId, Integer version, String name, int weight) {
        return new ProductEntity(productId,version,name,weight);
    }*/

    @Override
    public IProductEntity createProduct(Long productId, Integer version, String name, int weight, Set<RecommendationEntity> recommendations, Set<ReviewEntity> reviews) {
        return new ProductEntity(productId,version,name,weight,recommendations,reviews);
    }
}
