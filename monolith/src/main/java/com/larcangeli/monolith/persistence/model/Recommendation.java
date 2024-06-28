package com.larcangeli.monolith.persistence.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Version;

@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;

    @Version
    private Integer version;

    @OneToOne(optional = false)
    private Product product;
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

    public Long getId() {
        return recommendationId;
    }

    public Integer getVersion() {
        return version;
    }

    public Product getProductId() {
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

    public void setId(Long recommendationId) {
        this.recommendationId = recommendationId;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setProductId(Product product) {
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
}
