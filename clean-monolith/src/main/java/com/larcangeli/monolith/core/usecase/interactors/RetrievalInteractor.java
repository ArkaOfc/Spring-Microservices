package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.web.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.core.usecase.DTO.ProductAggregateDTO;
import com.larcangeli.monolith.core.usecase.boundaries.input.RetrievalInputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.output.RetrievalOutputBoundary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
