package com.larcangeli.monolith.core.entity.interfaces;

public interface IReviewEntity {
    Long getProductId();
    Long getReviewId();
    String getAuthor();
    String getContent();
    String getSubject();
}
