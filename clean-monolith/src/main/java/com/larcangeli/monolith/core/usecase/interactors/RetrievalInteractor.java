package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.web.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;
import com.larcangeli.monolith.core.usecase.DTO.ProductAggregateDTO;
import com.larcangeli.monolith.core.usecase.DTO.RecommendationDTO;
import com.larcangeli.monolith.core.usecase.DTO.ReviewDTO;
import com.larcangeli.monolith.core.usecase.boundaries.input.RetrievalInputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.output.RetrievalOutputBoundary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple use case that implements the logic of retrieving entities
 */
@Component
public class RetrievalInteractor implements RetrievalInputBoundary {

    RetrievalOutputBoundary retrievalOutputBoundary;
    ProductAggregateMapper productMapper;

    public RetrievalInteractor(RetrievalOutputBoundary retrievalOutputBoundary, ProductAggregateMapper productMapper) {
        this.retrievalOutputBoundary = retrievalOutputBoundary;
        this.productMapper = productMapper;
    }

    @Override
    public ProductAggregateDTO getProduct(Long productId) {
        return productMapper.productEntityToProductDTO(retrievalOutputBoundary.getProduct(productId));
    }

    @Override
    public List<ProductAggregateDTO> getAllProducts() {
        List<ProductAggregateDTO> products = new ArrayList<>();

        retrievalOutputBoundary.getAllProducts().forEach(p -> {
            products.add(productMapper.productEntityToProductDTO(p));
        });

        return products;
    }
}
