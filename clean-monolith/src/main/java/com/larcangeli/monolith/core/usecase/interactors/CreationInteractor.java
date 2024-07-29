package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.web.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.adapters.web.mapper.RecommendationMapper;
import com.larcangeli.monolith.adapters.web.mapper.ReviewMapper;
import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductFactory;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationFactory;
import com.larcangeli.monolith.core.entity.interfaces.IReviewFactory;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;
import com.larcangeli.monolith.core.usecase.DTO.ProductAggregateDTO;
import com.larcangeli.monolith.core.usecase.DTO.RecommendationDTO;
import com.larcangeli.monolith.core.usecase.DTO.ReviewDTO;
import com.larcangeli.monolith.core.usecase.boundaries.input.CreationInputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.output.CreationOutputBoundary;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple use case that implements the logic of saving entities
 */
@Component
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
                              CreationOutputBoundary creationOutputBoundary,
                              RecommendationMapper recommendationMapper,
                              ReviewMapper reviewMapper,
                              ProductAggregateMapper productMapper) {
        this.productFactory = productFactory;
        this.recommendationFactory = recommendationFactory;
        this.reviewFactory = reviewFactory;
        this.creationOutputBoundary = creationOutputBoundary;
        this.recommendationMapper = recommendationMapper;
        this.reviewMapper = reviewMapper;
        this.productMapper = productMapper;
    }

    @Override
    public ProductAggregateDTO createProduct(ProductAggregateDTO p) {

        Set<IRecommendationEntity> recommendationEntities = new HashSet<>();
        Set<IReviewEntity> reviewEntities = new HashSet<>();


        if(!p.recommendations().isEmpty()){
            p.recommendations().forEach(r -> {
                IRecommendationEntity recommendation = new RecommendationEntity(r.productId(),r.author(),r.rating(),r.content());
                recommendationEntities.add(recommendation);
            });
        }
        if(!p.reviews().isEmpty()){
            p.reviews().forEach(r -> {
                IReviewEntity review = new ReviewEntity(r.productId(),r.author(),r.subject(),r.content());
                reviewEntities.add(review);
            });
        }

        IProductEntity product = productFactory.createProduct(p.version(),p.name(),p.weight(),recommendationEntities,reviewEntities);
        return productMapper.productEntityToProductDTO(creationOutputBoundary.saveProduct(product));
    }

    @Override
    public RecommendationDTO createRecommendation(RecommendationDTO r) {
        IRecommendationEntity recommendation = recommendationFactory.createRecommendation(r.productId(),
                r.version(), r.author(), r.rating(), r.content());

        return  recommendationMapper.recommendationEntityToRecommendationDTO(creationOutputBoundary.saveRecommendation(recommendation));
    }

    @Override
    public ReviewDTO createReview(ReviewDTO r) {
        IReviewEntity review = reviewFactory.createReview(r.productId(),
               r.author(), r.subject(), r.content());

        return  reviewMapper.reviewEntityToReviewDTO(creationOutputBoundary.saveReview(review));
    }
}
