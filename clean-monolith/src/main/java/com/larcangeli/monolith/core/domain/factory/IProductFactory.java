package com.larcangeli.monolith.core.domain.factory;

import com.larcangeli.monolith.core.interfaces.IProductEntity;

public interface IProductFactory {
    IProductEntity createProduct(Integer version, String name, int weight);
}
