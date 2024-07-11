package com.larcangeli.monolith.persistence.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Version;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Recommendation {

    //just for comparisons
    @Id
    @GeneratedValue
    private UUID uuid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Version
    private Integer version;

    private String author;
    private int rating;
    private String content;

    public Recommendation() {
    }

    public Recommendation(Product product, String author, int rating, String content) {
        this.product = product;
        this.author = author;
        this.rating = rating;
        this.content = content;
    }

    public Long getRecommendationId() {
        return recommendationId;
    }

    public Integer getVersion() {
        return version;
    }

    public Product getProduct() {
        return product;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public void setRecommendationId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recommendation that = (Recommendation) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
