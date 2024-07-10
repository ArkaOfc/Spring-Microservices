package com.larcangeli.monolith.mapper;

import com.larcangeli.monolith.persistence.model.Review;
import com.larcangeli.monolith.web.dto.ReviewDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDTO reviewToReviewDTO(Review r);

    Review reviewDTOToReview(ReviewDTO rDTO);
}
