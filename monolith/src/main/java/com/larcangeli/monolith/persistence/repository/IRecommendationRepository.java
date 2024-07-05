package com.larcangeli.monolith.persistence.repository;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRecommendationRepository extends CrudRepository<Recommendation, Long> {
    List<Recommendation> findAllByProduct(Product product);
    void deleteAllByProduct(Product product);
}

