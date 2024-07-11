package com.larcangeli.monolith.core.usecase.boundaries.input;

import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;

import java.util.List;

/**
 * A simple boundary that allows the Controller in the adapter layer to use all the functions related to a ProductComposite
 * without a direct interaction with the Use Case layer
 */
public interface ProductInputBoundaries {

    ProductAggregateDTO getProduct(Long productId);

    List<ProductAggregateDTO> getAllProducts();

    ProductAggregateDTO createProduct(ProductAggregateDTO productAggregateDTO);

    void deleteProduct(Long productId);

}
