package com.larcangeli.monolith.adapters.persistence.repository;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductCompositeRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findByNameContaining(String name);
}
