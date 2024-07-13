package com.larcangeli.monolith.core.entity.implementation;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;

public class RecommendationEntity implements IRecommendationEntity {
    Long productId;
    Long id;
    Integer version;
    String author;
    private int rating;
    String content;

    public RecommendationEntity(Long productId, String author, int rating, String content) {
        this.productId = productId;
        this.author = author;
        this.rating = rating;
        this.content = content;
    }

    public RecommendationEntity(Long productId, Integer version, String author, int rating, String content) {
        this.productId = productId;
        this.version = version;
        this.author = author;
        this.rating = rating;
        this.content = content;
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
    public String getAuthor() {
        return this.author;
    }

    @Override
    public int getRating() {
        return this.rating;
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
