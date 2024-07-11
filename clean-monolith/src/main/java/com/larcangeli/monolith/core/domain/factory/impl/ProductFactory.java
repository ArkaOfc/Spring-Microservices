package com.larcangeli.monolith.core.domain.factory.impl;

import com.larcangeli.monolith.core.domain.entities.ProductEntity;
import com.larcangeli.monolith.core.domain.factory.IProductFactory;
import com.larcangeli.monolith.core.interfaces.IProductEntity;

public class ProductFactory implements IProductFactory {
    @Override
    public IProductEntity createProduct(Integer version, String name, int weight) {
        return new ProductEntity(version,name,weight);
    }
}
