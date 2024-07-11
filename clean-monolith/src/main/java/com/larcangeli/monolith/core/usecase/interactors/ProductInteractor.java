package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;
import com.larcangeli.monolith.core.usecase.boundaries.input.ProductInputBoundaries;

import java.util.List;

/**
 * A simple use case that implements the logic of retrieving, saving and deleting a ProductComposite
 */
public class ProductInteractor implements ProductInputBoundaries {
    @Override
    public ProductAggregateDTO getProduct(Long productId) {
        return null;
    }

    @Override
    public List<ProductAggregateDTO> getAllProducts() {
        return null;
    }

    @Override
    public ProductAggregateDTO createProduct(ProductAggregateDTO productAggregateDTO) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }
}
