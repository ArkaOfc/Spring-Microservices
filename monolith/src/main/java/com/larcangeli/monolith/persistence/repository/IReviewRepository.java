package com.larcangeli.monolith.persistence.repository;

import com.larcangeli.monolith.persistence.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface IReviewRepository extends CrudRepository<Review, Long> {
}
