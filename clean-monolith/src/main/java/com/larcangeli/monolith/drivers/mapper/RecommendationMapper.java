package com.larcangeli.monolith.drivers.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.core.entity.recommendation.impl.RecommendationEntity;
import com.larcangeli.monolith.core.entity.recommendation.IRecommendationEntity;
import com.larcangeli.monolith.drivers.dto.RecommendationDTO;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    Recommendation entityToPersistence(IRecommendationEntity recommendationEntity);
    RecommendationEntity persistenceToEntity(Recommendation recommendation);
    Set<RecommendationEntity> persistenceToEntities(Set<Recommendation> recommendations);
    Set<Recommendation> entitiesToPersistence(Set<IRecommendationEntity> recommendationEntities);
    RecommendationDTO entityToDto(IRecommendationEntity recommendationEntity);
    RecommendationEntity dtoToEntity(RecommendationDTO recommendation);
}