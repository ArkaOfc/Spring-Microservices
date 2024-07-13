package com.larcangeli.monolith.core.entity.implementation;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;

import java.util.Set;

public class ProductEntity implements IProductEntity {

    Long id;
    Integer version;
    String name;
    int weight;
    Set<IRecommendationEntity> recommendations;
    Set<IReviewEntity> reviews;

    public ProductEntity(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public ProductEntity(Integer version, String name, int weight) {
        this.version = version;
        this.name = name;
        this.weight = weight;
    }

    public ProductEntity(Integer version, String name, int weight, Set<IRecommendationEntity> recommendations, Set<IReviewEntity> reviews) {
        this.version = version;
        this.name = name;
        this.weight = weight;
        this.recommendations = recommendations;
        this.reviews = reviews;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Integer getVersion() {
        return this.version;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public Set<IReviewEntity> getReviews() {
        return reviews;
    }

    @Override
    public Set<IRecommendationEntity> getRecommendations() {
        return recommendations;
    }
}
