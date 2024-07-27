package com.larcangeli.monolith.adapters.web.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.core.entity.implementation.RecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {
    Recommendation recommendationEntityToRecommendation(IRecommendationEntity recommendationEntity);
    IRecommendationEntity recommendationToRecommendationEntity(Recommendation recommendation);
    List<IRecommendationEntity> recommendationsToRecommendationEntities(List<Recommendation> recommendations);
    List<Recommendation> recommendationEntitiesToRecommendations(List<IRecommendationEntity> recommendationEntities);
}