package com.larcangeli.monolith.persistence.repository;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAllByProduct(Product product);
    void deleteAllByProduct(Product product);
}
