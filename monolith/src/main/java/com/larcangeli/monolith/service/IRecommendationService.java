package com.larcangeli.monolith.service;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IRecommendationService {
    Optional<Recommendation> findById(Long id);
    Collection<Recommendation> findAll();
    Recommendation save(Recommendation recommendation);
    List<Recommendation> findAllByProduct(Product product);
    void deleteById(Long id);
    void deleteAllByProduct(Product product);
}
