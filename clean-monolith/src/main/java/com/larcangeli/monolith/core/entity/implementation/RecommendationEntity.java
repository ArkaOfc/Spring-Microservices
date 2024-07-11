package com.larcangeli.monolith.core.entity.implementation;

import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;

public class RecommendationEntity implements IRecommendationEntity {
    Long id;
    Integer version;
    String author;
    String content;

    public RecommendationEntity(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public RecommendationEntity(Integer version, String author, String content) {
        this.version = version;
        this.author = author;
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
    public String getContent() {
        return this.content;
    }
}
