package com.larcangeli.monolith.core.usecase.boundaries.output;

import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.RecommendationDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;

public interface CreationOutputBoundary {
    ProductAggregateDTO saveProduct(IProductEntity product);

    RecommendationDTO saveRecommendation(IRecommendationEntity recommendation);

    ReviewDTO saveReview(IReviewEntity review);
}
