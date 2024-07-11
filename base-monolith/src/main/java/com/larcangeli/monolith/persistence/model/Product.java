package com.larcangeli.monolith.persistence.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Version;

import java.util.*;

@Entity
public class Product {

    //just for comparisons
    @Id
    @GeneratedValue
    private UUID uuid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @OneToMany(mappedBy = "product")
    private Set<Recommendation> recommendations;
    @OneToMany(mappedBy = "product")
    private Set<Review> reviews;

    @Version
    private Integer version;
    private String name;
    private int weight;

    public Product(){
        name = null;
        weight = 0;
    }

    public Product(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public Product(Set<Recommendation> recommendations, Set<Review> reviews) {
        this.recommendations = recommendations;
        this.reviews = reviews;
        name = null;
        weight = 0;
    }

    public Product(Set<Recommendation> recommendations, Set<Review> reviews, String name, int weight) {
        this.recommendations = recommendations;
        this.reviews = reviews;
        this.name = name;
        this.weight = weight;
    }

    public Product(Set<Recommendation> recommendations, Set<Review> reviews, String name, int weight, Integer version) {
        this.recommendations = recommendations;
        this.reviews = reviews;
        this.name = name;
        this.weight = weight;
        this.version = version;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Set<Recommendation> getAllRecommendations() {
        return recommendations;
    }

    public Recommendation getRecommendation(Long recommendationId){
        try{
            return recommendations.stream().filter(r -> r.getRecommendationId().equals(recommendationId)).findFirst().get();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    public void setAllRecommendations(Set<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public Set<Review> getAllReviews() {
        return reviews;
    }

    public void setAllReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Review getReview(Long reviewId){
        try{
            return reviews.stream().filter(r -> r.getReviewId().equals(reviewId)).findFirst().get();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(uuid, product.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
