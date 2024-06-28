package com.larcangeli.monolith.persistence.repository;

import com.larcangeli.monolith.persistence.model.Recommendation;
import org.springframework.data.repository.CrudRepository;

public interface IRecommendationRepository extends CrudRepository<Recommendation, Long> {
}
