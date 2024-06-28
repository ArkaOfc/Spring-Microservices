package com.larcangeli.monolith.persistence.repository;

import com.larcangeli.monolith.persistence.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findByNameContaining(String name);
}
