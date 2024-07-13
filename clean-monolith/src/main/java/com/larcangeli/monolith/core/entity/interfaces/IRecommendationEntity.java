package com.larcangeli.monolith.core.entity.interfaces;

public interface IRecommendationEntity {
    Long getId();
    Integer getVersion();
    String getAuthor();
    int getRating();
    String getContent();

}
