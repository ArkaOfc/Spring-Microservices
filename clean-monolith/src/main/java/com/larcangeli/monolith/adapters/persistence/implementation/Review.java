package com.larcangeli.monolith.adapters.persistence.implementation;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private String author;
    private String subject;
    private String content;

    public Review() {
    }

    public Review(Product product, String author, String subject, String content) {
        this.product = product;
        this.author = author;
        this.subject = subject;
        this.content = content;
    }

    public Product getProduct() {
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

    public void setProduct(Product product) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(product, review.product) && Objects.equals(reviewId, review.reviewId) && Objects.equals(author, review.author) && Objects.equals(subject, review.subject) && Objects.equals(content, review.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, reviewId, author, subject, content);
    }
}
