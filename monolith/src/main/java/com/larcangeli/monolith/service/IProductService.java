package com.larcangeli.monolith.service;

import com.larcangeli.monolith.persistence.model.Product;

import java.util.Collection;
import java.util.Optional;

public interface IProductService {
    Optional<Product> findById(Long id);
    Collection<Product> findAll();
    Product save(Product product);

    void deleteById(Long id);
}
