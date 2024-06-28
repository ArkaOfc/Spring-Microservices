package com.larcangeli.monolith.service;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.service.impl.RecommendationService;

import java.util.Collection;
import java.util.Optional;

public interface IRecommendationService {
    Optional<Recommendation> findById(Long id);
    Collection<Recommendation> findAll();
    Recommendation save(Recommendation recommendation);
}
