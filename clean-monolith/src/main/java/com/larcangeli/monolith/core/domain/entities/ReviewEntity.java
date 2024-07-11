package com.larcangeli.monolith.core.domain.entities;

import com.larcangeli.monolith.core.interfaces.IReviewEntity;

public class ReviewEntity implements IReviewEntity {
    Long id;
    String author;
    String subject;
    String content;

    public ReviewEntity(String author, String subject, String content) {
        this.author = author;
        this.subject = subject;
        this.content = content;
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
