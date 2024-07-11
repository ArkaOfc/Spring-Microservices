package com.larcangeli.monolith.adapters.service.impl;

import com.larcangeli.monolith.adapters.service.IProductCompositeService;
import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.adapters.persistence.implementation.Review;
import com.larcangeli.monolith.adapters.persistence.repository.IProductCompositeRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductCompositeService implements IProductCompositeService {

    private final IProductCompositeRepository productRepository;

    public ProductCompositeService(IProductCompositeRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Long id){return productRepository.findById(id);}
    @Override
    public Collection<Product> findAll(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Recommendation saveRecommendation(Recommendation recommendation) {
        recommendation.getProduct().getAllRecommendations().add(recommendation);
        return recommendation;
    }

    @Override
    public Review saveReview(Review review) {
        review.getProduct().getAllReviews().add(review);
        return review;
    }

    @Override
    public void deleteRecommendation(Long recommendationId) {

        if(this.findAll().stream().anyMatch(p -> p.getRecommendation(recommendationId) != null)){
            Product prod = this.findAll().stream().filter(p -> p.getRecommendation(recommendationId) != null).findFirst().get();
            prod.getAllRecommendations().remove(prod.getRecommendation(recommendationId));
        }
        else throw new NoSuchElementException();

    }

    @Override
    public void deleteReview(Long reviewId) {
        if(this.findAll().stream().anyMatch(p -> p.getReview(reviewId) != null)){
            Product prod = this.findAll().stream().filter(p -> p.getReview(reviewId) != null).findFirst().get();
            prod.getAllReviews().remove(prod.getReview(reviewId));
        }
        else throw new NoSuchElementException();
    }

    @Override
    public List<Recommendation> findRecommendationsByProduct(Product p) {
        return p.getAllRecommendations();
    }

    @Override
    public List<Review> findReviewsByProduct(Product p) {
        return p.getAllReviews();
    }


}
