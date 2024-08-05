package com.larcangeli.monolith.recommendation.domain;

public class RecommendationNotFoundException extends RuntimeException{
    public RecommendationNotFoundException(String message) {
        super(message);
    }

    public static RecommendationNotFoundException forId(Long id) {
        return new RecommendationNotFoundException("Recommendation with ID: " + id + " not found");
    }
}
