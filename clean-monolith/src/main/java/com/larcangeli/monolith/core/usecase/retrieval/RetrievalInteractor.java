package com.larcangeli.monolith.core.usecase.retrieval;

import com.larcangeli.monolith.core.entity.product.IProductEntity;
import com.larcangeli.monolith.drivers.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.drivers.dto.ProductAggregateDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple use case that implements the logic of retrieving entities
 */
@Component
public class RetrievalInteractor implements RetrievalInputBoundary {

    RetrievalOutputBoundary retrievalOutputBoundary;

    public RetrievalInteractor(RetrievalOutputBoundary retrievalOutputBoundary) {
        this.retrievalOutputBoundary = retrievalOutputBoundary;
    }

    @Override
    public IProductEntity getProduct(Long productId) {
        return retrievalOutputBoundary.getProduct(productId);
    }

    @Override
    public List<IProductEntity> getAllProducts() {
        return retrievalOutputBoundary.getAllProducts();
    }
}