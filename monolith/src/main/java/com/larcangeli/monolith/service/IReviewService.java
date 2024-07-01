package com.larcangeli.monolith.service;

import com.larcangeli.monolith.persistence.model.Review;

import java.util.Collection;
import java.util.Optional;

public interface IReviewService {
    Optional<Review> findById(Long id);
    Collection<Review> findAll();
    Review save(Review review);

    void deleteById(Long id);
}
