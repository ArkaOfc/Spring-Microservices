package com.larcangeli.monolith.service.impl;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.persistence.model.Review;
import com.larcangeli.monolith.persistence.repository.IProductCompositeRepository;
import com.larcangeli.monolith.service.IProductCompositeService;
import com.larcangeli.monolith.util.exceptions.NotFoundException;
import com.larcangeli.monolith.web.controller.ProductCompositeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductCompositeService implements IProductCompositeService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeController.class);

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
        Optional<Product> p = productRepository.findById(id);
        if(p.isEmpty())
            throw new NotFoundException();
        p.get().deleteAllRecommendations();
        p.get().deleteAllReviews();
        productRepository.deleteById(id);
    }

    @Override
    public void saveRecommendation(Recommendation recommendation) {
        Optional<Product> p = productRepository.findById(recommendation.getProductId());
        if(p.isPresent()){
            p.get().addRecommendation(recommendation);
        }else throw new NoSuchElementException();
    }

    @Override
    public void saveReview(Review review){
        Optional<Product> p = productRepository.findById(review.getProductId());
        if(p.isPresent()){
            p.get().addReview(review);
        }else throw new NoSuchElementException();
    }

    @Override
    public void deleteRecommendation(Long recommendationId) {
        Optional<Product> prod = this.findAll().stream().filter(p -> p.getRecommendation(recommendationId) != null).findFirst();
        if(prod.isEmpty())
            throw new NotFoundException();
        prod.get().removeRecommendation(prod.get().getRecommendation(recommendationId));
    }

    @Override
    public void deleteReview(Long reviewId) {
        Optional<Product> prod = this.findAll().stream().filter(p -> p.getReview(reviewId) != null).findFirst();
        if(prod.isEmpty()){
            throw new NotFoundException();
        }
        prod.get().removeReview(prod.get().getReview(reviewId));
    }

    @Override
    public Set<Recommendation> findRecommendationsByProductId(Long productId) {
        if(productRepository.findById(productId).isPresent()){
            return productRepository.findById(productId).get().getAllRecommendations();
        }else throw new NoSuchElementException();
    }

    @Override
    public Set<Review> findReviewsByProductId(Long productId) {
        if(productRepository.findById(productId).isPresent()){
            return productRepository.findById(productId).get().getAllReviews();
        }else throw new NoSuchElementException();
    }


}
