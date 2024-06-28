package com.larcangeli.monolith.persistence.model;

import jakarta.persistence.*;

@Entity
public class Review {
    @OneToOne(optional = false)
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String author;
    private String subject;
    private String content;

    public Review() {
        product = new Product();
        author = null;
        subject = null;
        content = null;
    }

    public Review(Product product, String author, String subject, String content) {
        this.product = product;
        this.author = author;
        this.subject = subject;
        this.content = content;
    }

    public Product getProductId() {
        return product;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public void setProductId(Product product) {
        this.product = product;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
