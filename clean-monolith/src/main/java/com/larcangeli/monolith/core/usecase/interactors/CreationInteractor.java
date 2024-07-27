package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.web.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.adapters.web.mapper.RecommendationMapper;
import com.larcangeli.monolith.adapters.web.mapper.ReviewMapper;
import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.RecommendationDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;
import com.larcangeli.monolith.core.entity.interfaces.IProductFactory;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationFactory;
import com.larcangeli.monolith.core.entity.interfaces.IReviewFactory;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;
import com.larcangeli.monolith.core.usecase.boundaries.input.CreationInputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.output.CreationOutputBoundary;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple use case that implements the logic of saving entities
 */
public class CreationInteractor implements CreationInputBoundary {

    final IProductFactory productFactory;
    final IRecommendationFactory recommendationFactory;
    final IReviewFactory reviewFactory;
    final CreationOutputBoundary creationOutputBoundary;
    final RecommendationMapper recommendationMapper;
    final ReviewMapper reviewMapper;
    final ProductAggregateMapper productMapper;

    public CreationInteractor(IProductFactory productFactory,
                              IRecommendationFactory recommendationFactory,
                              IReviewFactory reviewFactory,
                              CreationOutputBoundary creationOutputBoundary, RecommendationMapper recommendationMapper, ReviewMapper reviewMapper, ProductAggregateMapper productMapper) {
        this.productFactory = productFactory;
        this.recommendationFactory = recommendationFactory;
        this.reviewFactory = reviewFactory;
        this.creationOutputBoundary = creationOutputBoundary;
        this.recommendationMapper = recommendationMapper;
        this.reviewMapper = reviewMapper;
        this.productMapper = productMapper;
    }

    @Override
    public ProductAggregateDTO createProduct(ProductAggregateDTO productAggregateDTO) {

        Set<IRecommendationEntity> recommendationEntities = new HashSet<>();
        Set<IReviewEntity> reviewEntities = new HashSet<>();

        if(!productAggregateDTO.recommendations().isEmpty()){
            recommendationEntities = recommendationMapper.recommendationDTOsToRecommendationEntities(productAggregateDTO.recommendations());
        }
        if(!productAggregateDTO.reviews().isEmpty()){
            reviewEntities = reviewMapper.reviewDTOsToReviewEntities(productAggregateDTO.reviews());
        }

        IProductEntity product = productFactory.createProduct(productAggregateDTO.version(),
                productAggregateDTO.name(),
                productAggregateDTO.weight(),
                recommendationEntities,
                reviewEntities
                );

        return creationOutputBoundary.saveProduct(product);
    }

    @Override
    public RecommendationDTO createRecommendation(RecommendationDTO recommendationDTO) {
        IRecommendationEntity recommendation = recommendationFactory.createRecommendation(recommendationDTO.productId(),
                recommendationDTO.version(), recommendationDTO.author(), recommendationDTO.rating(), recommendationDTO.content());

        return  creationOutputBoundary.saveRecommendation(recommendation);
    }

    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        IReviewEntity review = reviewFactory.createReview(reviewDTO.productId(),
               reviewDTO.author(), reviewDTO.subject(), reviewDTO.content());

        return  creationOutputBoundary.saveReview(review);
    }
}
