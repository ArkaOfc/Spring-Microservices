package com.larcangeli.monolith.recommendation.domain;

import com.larcangeli.monolith.recommendation.IRecommendationService;
import com.larcangeli.monolith.recommendation.RecommendationDTO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
class RecommendationService implements IRecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final RecommendationMapper recommendationMapper;

    public RecommendationService(RecommendationRepository recommendationRepository, RecommendationMapper recommendationMapper) {
        this.recommendationRepository = recommendationRepository;
        this.recommendationMapper = recommendationMapper;
    }

    @Override
    public RecommendationDTO save(RecommendationDTO recommendation) {
       return recommendationMapper.recommendationToRecommendationDTO(recommendationRepository.save(recommendationMapper.recommendationDTOToRecommendation(recommendation)));
    }

    @Override
    public void deleteById(Long recommendationId) {
        if(recommendationRepository.findById(recommendationId).isPresent()){
            recommendationRepository.deleteById(recommendationId);
        }else throw RecommendationNotFoundException.forId(recommendationId);
    }

    @Override
    public void deleteRecommendations(Long productId) {
        recommendationRepository.deleteAll(recommendationRepository.findRecommendationsByProductId(productId));
    }

    @Override
    public List<RecommendationDTO> findRecommendationsByProductId(Long productId) {
        return recommendationMapper.recommendationsToRecommendationDTOs(recommendationRepository.findRecommendationsByProductId(productId));
    }


}
