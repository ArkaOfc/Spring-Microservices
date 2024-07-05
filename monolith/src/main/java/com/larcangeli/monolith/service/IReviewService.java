package com.larcangeli.monolith.service;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Review;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IReviewService {
    Optional<Review> findById(Long id);
    Collection<Review> findAll();
    Review save(Review review);
    List<Review> findAllByProduct(Product product);
    void deleteById(Long id);
    void deleteAllByProduct(Product product);
}
