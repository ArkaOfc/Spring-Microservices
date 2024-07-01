package com.larcangeli.monolith.service;

import com.larcangeli.monolith.persistence.model.Recommendation;

import java.util.Collection;
import java.util.Optional;

public interface IRecommendationService {
    Optional<Recommendation> findById(Long id);
    Collection<Recommendation> findAll();
    Recommendation save(Recommendation recommendation);

    void deleteById(Long id);
}
