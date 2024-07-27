package com.larcangeli.monolith.core.usecase.boundaries.input;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;

import java.util.List;

/**
 * A simple boundary that allows the Controller in the adapter layer to use all the underlying functions
 * without a direct interaction with the Use Case layer
 */
public interface RetrievalInputBoundary {
    IProductEntity getProduct(Long productId);

    List<IProductEntity> getAllProducts();
}