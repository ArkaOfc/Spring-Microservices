package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;
import com.larcangeli.monolith.core.usecase.boundaries.input.RetrievalInputBoundary;

import java.util.List;

/**
 * A simple use case that implements the logic of retrieving entities
 */
public class RetrievalInteractor implements RetrievalInputBoundary {
    @Override
    public ProductAggregateDTO getProduct(Long productId) {
        return null;
    }

    @Override
    public List<ProductAggregateDTO> getAllProducts() {
        return null;
    }

}
