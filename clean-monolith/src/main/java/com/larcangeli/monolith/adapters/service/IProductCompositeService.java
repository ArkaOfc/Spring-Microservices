package com.larcangeli.monolith.adapters.service;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.adapters.persistence.implementation.Review;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IProductCompositeService {
    Optional<Product> findById(Long id);

    Collection<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);

    Recommendation saveRecommendation(Recommendation recommendation);

    Review saveReview(Review review);

    void deleteRecommendation(Long recommendationId);

    void deleteReview(Long reviewId);

    List<Recommendation> findRecommendationsByProduct(Product p);

    List<Review> findReviewsByProduct(Product p);
}
