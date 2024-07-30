package com.larcangeli.monolith.core.entity.interfaces;

public interface IRecommendationEntity {
    Long getProductId();
    Long getRecommendationId();
    Integer getVersion();
    String getAuthor();
    int getRating();
    String getContent();

}
