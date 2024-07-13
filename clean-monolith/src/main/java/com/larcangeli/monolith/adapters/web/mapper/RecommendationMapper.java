package com.larcangeli.monolith.adapters.web.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.adapters.web.mapper.dto.RecommendationDTO;
import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    RecommendationDTO recommendationToRecommendationDTO(Recommendation r);
    List<RecommendationDTO> recommendationsToRecommendationDTOs(Set<Recommendation> rs);
    Recommendation recommendationDTOToRecommendation(RecommendationDTO rDTO);
    Set<Recommendation> recommendationDTOsToRecommendations(List<RecommendationDTO> rDTOs);
    IRecommendationEntity recommendationDTOToRecommendationEntity(RecommendationDTO rDTO);
    RecommendationDTO recommendationEntityToRecommendationDTO(IRecommendationEntity re);
    Set<IRecommendationEntity> recommendationDTOsToRecommendationEntities(List<RecommendationDTO> rDTOs);
    List<RecommendationDTO> recommendationEntitiesToRecommendationDTOs(Set<IRecommendationEntity> res);
}
