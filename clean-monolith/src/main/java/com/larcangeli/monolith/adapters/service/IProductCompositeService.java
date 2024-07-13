package com.larcangeli.monolith.adapters.service;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.adapters.persistence.implementation.Review;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IProductCompositeService {
    Optional<Product> findById(Long id);

    Collection<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);

    void saveRecommendation(Recommendation recommendation);

    void saveReview(Review review);

    void deleteRecommendation(Long recommendationId);

    void deleteReview(Long reviewId);

    Set<Recommendation> findRecommendationsByProductId(Long productId);

    Set<Review> findReviewsByProductId(Long productId);
}
