package com.larcangeli.monolith.core.entity.implementation;

import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;

public class ReviewEntity implements IReviewEntity {
    Long productId;
    Long id;
    String author;
    String subject;
    String content;

    public ReviewEntity(){

    }

    public ReviewEntity(Long productId, String author, String subject, String content) {
        this.productId = productId;
        this.author = author;
        this.subject = subject;
        this.content = content;
    }

    @Override
    public Long getProductId() {
        return productId;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public String getSubject() {
        return this.subject;
    }
}
