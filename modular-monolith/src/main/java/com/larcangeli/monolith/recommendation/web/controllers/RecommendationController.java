package com.larcangeli.monolith.recommendation.web.controllers;

import com.larcangeli.monolith.recommendation.RecommendationDTO;
import com.larcangeli.monolith.recommendation.IRecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RecommendationController {

    private static final Logger LOG = LoggerFactory.getLogger(RecommendationController.class);

    private final IRecommendationService recommendationService;

    @Autowired
    public RecommendationController(IRecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping(value = "/product-composite/recommendation", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    RecommendationDTO createRecommendation(@RequestBody RecommendationDTO recommendation){
        LOG.debug("deleteCompositeProduct: Creates the recommendation with ID: {}", recommendation.recommendationId());

        try{
            RecommendationDTO r = recommendationService.save(recommendation);
            LOG.debug("deleteCompositeProduct: recommendations created with ID: {}", recommendation.recommendationId());
            return r;
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Recommendation with ID: " + recommendation.recommendationId() + " not found");
        }
    }

    @DeleteMapping(value = "/product-composite/recommendation/{recommendationId}")
    void deleteRecommendation(@PathVariable Long recommendationId){
        LOG.debug("deleteCompositeProduct: Deletes the recommendation with ID: {}", recommendationId);

        try{
            recommendationService.deleteById(recommendationId);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Recommendation with ID: " + recommendationId + " not found");
        }
        LOG.debug("deleteCompositeProduct: recommendations deleted for ID: {}", recommendationId);

    }

}
