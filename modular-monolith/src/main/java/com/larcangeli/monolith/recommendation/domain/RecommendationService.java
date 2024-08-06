package com.larcangeli.monolith.recommendation.domain;

import com.larcangeli.monolith.product.web.controllers.ProductController;
import com.larcangeli.monolith.recommendation.shared.IRecommendationService;
import com.larcangeli.monolith.recommendation.shared.RecommendationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class RecommendationService implements IRecommendationService {

    private final RecommendationRepository repo;
    private final RecommendationMapper mapper;

    public RecommendationService(RecommendationRepository recommendationRepository, RecommendationMapper recommendationMapper) {
        this.repo = recommendationRepository;
        this.mapper = recommendationMapper;
    }

    @Override
    public RecommendationDTO save(RecommendationDTO recommendation) {
       return mapper.toDTO(repo.save(mapper.toEntity(recommendation)));
    }

    @Override
    public void saveRecommendationOnProductCreation(RecommendationDTO recommendation) {
        repo.save(mapper.toEntity(recommendation));
    }

    @Override
    public void deleteById(Long recommendationId) {
        if(repo.findById(recommendationId).isPresent()){
            repo.deleteById(recommendationId);
        }else throw RecommendationNotFoundException.forId(recommendationId);
    }

    @Override
    public void deleteRecommendations(Long productId) {
        repo.deleteAll(repo.findRecommendationsByProductId(productId));
    }

    @Override
    public List<RecommendationDTO> findRecommendationsByProductId(Long productId) {
        return mapper.toDTOs(repo.findRecommendationsByProductId(productId));
    }


}
