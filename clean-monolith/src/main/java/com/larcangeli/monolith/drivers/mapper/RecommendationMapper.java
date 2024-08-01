package com.larcangeli.monolith.drivers.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.core.entity.recommendation.impl.RecommendationEntity;
import com.larcangeli.monolith.core.entity.recommendation.IRecommendationEntity;
import com.larcangeli.monolith.drivers.dto.RecommendationDTO;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    Recommendation recommendationEntityToRecommendation(IRecommendationEntity recommendationEntity);
    RecommendationEntity recommendationToRecommendationEntity(Recommendation recommendation);
    Set<RecommendationEntity> recommendationsToRecommendationEntities(Set<Recommendation> recommendations);
    Set<Recommendation> recommendationEntitiesToRecommendations(Set<IRecommendationEntity> recommendationEntities);
    RecommendationDTO recommendationEntityToRecommendationDTO(IRecommendationEntity recommendationEntity);
    RecommendationEntity recommendationDTOToRecommendationEntity(RecommendationDTO recommendation);
}