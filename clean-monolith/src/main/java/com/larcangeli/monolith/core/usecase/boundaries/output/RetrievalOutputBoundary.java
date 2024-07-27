package com.larcangeli.monolith.core.usecase.boundaries.output;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;

import java.util.List;

public interface RetrievalOutputBoundary {
    IProductEntity getProduct(Long productId);

    List<IProductEntity> getAllProducts();
}
