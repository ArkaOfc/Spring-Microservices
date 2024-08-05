package com.larcangeli.monolith.recommendation.domain;

import com.larcangeli.monolith.recommendation.RecommendationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
interface RecommendationMapper {
    RecommendationDTO recommendationToRecommendationDTO(Recommendation r);
    List<RecommendationDTO> recommendationsToRecommendationDTOs(List<Recommendation> rs);
    Recommendation recommendationDTOToRecommendation(RecommendationDTO rDTO);
    List<Recommendation> recommendationDTOsToRecommendations(List<RecommendationDTO> rDTOs);
}
