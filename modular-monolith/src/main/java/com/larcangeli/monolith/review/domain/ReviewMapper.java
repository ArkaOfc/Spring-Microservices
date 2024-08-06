package com.larcangeli.monolith.review.domain;

import com.larcangeli.monolith.review.shared.ReviewDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface ReviewMapper {
    ReviewDTO toDTO(Review r);
    List<ReviewDTO> toDTOs(List<Review> rs);
    Review toEntity(ReviewDTO rDTO);
    List<Review> toEntities(List<ReviewDTO> rDTOs);
}
