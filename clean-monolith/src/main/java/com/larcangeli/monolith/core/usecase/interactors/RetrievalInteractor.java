package com.larcangeli.monolith.core.usecase.interactors;

import com.larcangeli.monolith.adapters.web.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;
import com.larcangeli.monolith.core.entity.implementation.ProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.usecase.boundaries.input.RetrievalInputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.output.RetrievalOutputBoundary;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple use case that implements the logic of retrieving entities
 */
public class RetrievalInteractor implements RetrievalInputBoundary {

    RetrievalOutputBoundary retrievalOutputBoundary;
    ProductAggregateMapper productMapper;

    @Override
    public ProductAggregateDTO getProduct(Long productId) {
        ProductEntity p = retrievalOutputBoundary.getProduct(productId);
        return productMapper.productEntityToProductAggregateDTO(p);
    }

    @Override
    public List<ProductAggregateDTO> getAllProducts() {
        List<IProductEntity> products = new ArrayList<>(retrievalOutputBoundary.getAllProducts());
        return productMapper.productEntitiesToProductAggregateDTOs(products);
    }

}
