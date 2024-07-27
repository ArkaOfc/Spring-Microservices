package com.larcangeli.monolith.adapters.persistence.repository;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.persistence.implementation.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductCompositeRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findByNameContaining(String name);

    @Query("SELECT r FROM Review r WHERE r.productId = :productId")
    List<Review> findReviewsByProductId(Long productId);


}
