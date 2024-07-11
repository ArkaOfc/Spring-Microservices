package com.larcangeli.monolith.service;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.persistence.model.Review;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IProductCompositeService {
    Optional<Product> findById(Long id);

    Collection<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);

    Recommendation saveRecommendation(Recommendation recommendation);

    Review saveReview(Review review);

    void deleteRecommendation(Long recommendationId);

    void deleteReview(Long reviewId);

    Set<Recommendation> findRecommendationsByProduct(Product p);

    Set<Review> findReviewsByProduct(Product p);
}
