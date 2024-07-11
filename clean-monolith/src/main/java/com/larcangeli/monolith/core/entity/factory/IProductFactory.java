package com.larcangeli.monolith.core.entity.factory;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;

public interface IProductFactory {
    IProductEntity createProduct(Integer version, String name, int weight);
}
