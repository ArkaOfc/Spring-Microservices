package com.larcangeli.monolith.drivers.mapper;
import com.larcangeli.monolith.adapters.persistence.implementation.Review;
import com.larcangeli.monolith.core.entity.review.impl.ReviewEntity;
import com.larcangeli.monolith.core.entity.review.IReviewEntity;
import com.larcangeli.monolith.drivers.dto.ReviewDTO;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    Review reviewEntityToReview(IReviewEntity reviewEntity);
    ReviewEntity reviewToReviewEntity(Review review);
    Set<ReviewEntity> reviewsToReviewEntities(Set<Review> reviews);
    Set<Review> reviewEntitiesToReviews(Set<IReviewEntity> reviewEntities);
    ReviewDTO reviewEntityToReviewDTO(IReviewEntity reviewEntity);
    ReviewEntity reviewDTOToReviewEntity(ReviewDTO review);

}
