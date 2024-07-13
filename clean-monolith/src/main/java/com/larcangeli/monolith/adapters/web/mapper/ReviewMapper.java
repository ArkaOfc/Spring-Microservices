package com.larcangeli.monolith.adapters.web.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Review;
import com.larcangeli.monolith.adapters.web.mapper.dto.RecommendationDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;
import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDTO reviewToReviewDTO(Review r);
    List<ReviewDTO> reviewsToReviewDTOs(Set<Review> rs);
    Review reviewDTOToReview(ReviewDTO rDTO);
    Set<Review> reviewDTOsToReviews(List<ReviewDTO> rDTOs);
    IReviewEntity reviewDTOToReviewEntity(ReviewDTO rDTO);
    ReviewDTO reviewEntityToReviewDTO(IReviewEntity r);
    Set<IReviewEntity> reviewDTOsToReviewEntities(List<ReviewDTO> rDTOs);
    List<ReviewDTO> reviewEntitiesToReviewDTOs(Set<IReviewEntity> res);
}
