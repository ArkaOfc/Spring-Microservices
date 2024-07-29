package com.larcangeli.monolith.core.usecase.boundaries.output;

import com.larcangeli.monolith.core.entity.implementation.ProductEntity;
import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;

import java.util.List;
import java.util.Set;

public interface RetrievalOutputBoundary {
    IProductEntity getProduct(Long productId);

    List<IProductEntity> getAllProducts();

    Set<RecommendationEntity> findRecommendationsByProductId(Long productId);

    Set<ReviewEntity> findReviewsByProductId(Long productId);
}
