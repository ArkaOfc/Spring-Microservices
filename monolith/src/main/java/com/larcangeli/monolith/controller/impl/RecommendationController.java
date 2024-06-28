package com.larcangeli.monolith.controller.impl;

import com.larcangeli.monolith.controller.IRecommendationController;
import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.service.IProductService;
import com.larcangeli.monolith.service.IRecommendationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
public class RecommendationController implements IRecommendationController {
    IRecommendationService recommendationService;

    public RecommendationController(IRecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @Override
    public Recommendation findById(Long recommendation_id) {
        return recommendationService.findById(recommendation_id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
    }

    @Override
    public Collection<Recommendation> findAll() {
        return recommendationService.findAll();
    }

    @Override
    public Recommendation create(Recommendation recommendation) {
        return recommendationService.save(recommendation);
    }
}
