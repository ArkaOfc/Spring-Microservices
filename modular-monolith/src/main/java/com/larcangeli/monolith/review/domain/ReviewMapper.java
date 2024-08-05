package com.larcangeli.monolith.review.domain;

import com.larcangeli.monolith.review.ReviewDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface ReviewMapper {
    ReviewDTO reviewToReviewDTO(Review r);
    List<ReviewDTO> reviewsToReviewDTOs(List<Review> rs);
    Review reviewDTOToReview(ReviewDTO rDTO);
    List<Review> reviewDTOsToReviews(List<ReviewDTO> rDTOs);
}
