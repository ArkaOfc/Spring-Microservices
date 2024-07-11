package com.larcangeli.monolith.core.entity.factory.impl;

import com.larcangeli.monolith.core.entity.implementation.ProductEntity;
import com.larcangeli.monolith.core.entity.factory.IProductFactory;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;

public class ProductFactory implements IProductFactory {
    @Override
    public IProductEntity createProduct(Integer version, String name, int weight) {
        return new ProductEntity(version,name,weight);
    }
}
