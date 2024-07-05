package com.larcangeli.monolith.service.impl;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.persistence.repository.IRecommendationRepository;
import com.larcangeli.monolith.service.IRecommendationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService implements IRecommendationService {

    private IRecommendationRepository recommendationRepository;

    public RecommendationService(IRecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public Optional<Recommendation> findById(Long id){
        return recommendationRepository.findById(id);
    }
    @Override
    public Collection<Recommendation> findAll(){
        List<Recommendation> recommendations = new ArrayList<>();
        recommendationRepository.findAll().forEach(recommendations::add);
        return recommendations;
    }
    @Override
    public Recommendation save(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    @Override
    public List<Recommendation> findAllByProduct(Product product) {
        return recommendationRepository.findAllByProduct(product);
    }

    @Override
    public void deleteById(Long id) {
        recommendationRepository.deleteById(id);
    }

    @Override
    public void deleteAllByProduct(Product product) {
        recommendationRepository.deleteAllByProduct(product);
    }

}
