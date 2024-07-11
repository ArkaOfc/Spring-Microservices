package com.larcangeli.monolith.core.usecase.boundaries;

import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.RecommendationDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;

import java.util.List;

/**
 * A simple boundary that allows the Controller in the adapter layer to use all the underlying functions
 * without a direct interaction with the Use Case layer
 */
public interface InputBoundaries {

    ProductAggregateDTO getProduct(Long productId);

    List<ProductAggregateDTO> getAllProducts();

    ProductAggregateDTO createProduct(ProductAggregateDTO productAggregateDTO);

    void deleteProduct(Long productId);

    RecommendationDTO createRecommendation(RecommendationDTO recommendationDTO);

    void deleteRecommendation(Long recommendationId);

    ReviewDTO createReview(ReviewDTO review);

    void deleteReview(Long reviewId);
}
