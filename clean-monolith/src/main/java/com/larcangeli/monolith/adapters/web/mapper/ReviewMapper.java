package com.larcangeli.monolith.adapters.web.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Review;
import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDTO reviewToReviewDTO(Review r);

    Review reviewDTOToReview(ReviewDTO rDTO);
}
