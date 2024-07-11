package com.larcangeli.monolith.adapters.web.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.adapters.web.mapper.dto.RecommendationDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    RecommendationDTO recommendationToRecommendationDTO(Recommendation r);
    Recommendation recommendationDTOToRecommendation(RecommendationDTO rDTO);
}
