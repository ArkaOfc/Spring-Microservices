package com.larcangeli.monolith.persistence.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Version;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @OneToMany(mappedBy = "product")
    private List<Recommendation> recommendations;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

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

    public Product(List<Recommendation> recommendations, List<Review> reviews) {
        this.recommendations = recommendations;
        this.reviews = reviews;
        name = null;
        weight = 0;
    }

    public Product(List<Recommendation> recommendations, List<Review> reviews, String name, int weight) {
        this.recommendations = recommendations;
        this.reviews = reviews;
        this.name = name;
        this.weight = weight;
    }

    public Product(List<Recommendation> recommendations, List<Review> reviews, String name, int weight, Integer version) {
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

    public List<Recommendation> getAllRecommendations() {
        return recommendations;
    }

    public Recommendation getRecommendation(Long recommendationId){
        try{
            return recommendations.stream().filter(r -> r.getRecommendationId().equals(recommendationId)).findFirst().get();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException();
        }
    }

    public void setAllRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    public List<Review> getAllReviews() {
        return reviews;
    }

    public void setAllReviews(List<Review> reviews) {
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
        return weight == product.weight && Objects.equals(productId, product.productId) && Objects.equals(version, product.version) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, version, name, weight);
    }
}
