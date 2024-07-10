package com.larcangeli.monolith.mapper;

import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.web.dto.RecommendationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    RecommendationDTO recommendationToRecommendationDTO(Recommendation r);
    Recommendation recommendationDTOToRecommendation(RecommendationDTO rDTO);
}
