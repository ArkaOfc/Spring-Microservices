package com.larcangeli.monolith.adapters.web.controller;

import com.larcangeli.monolith.adapters.web.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.adapters.web.mapper.RecommendationMapper;
import com.larcangeli.monolith.adapters.web.mapper.ReviewMapper;
import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.persistence.implementation.Recommendation;
import com.larcangeli.monolith.adapters.persistence.implementation.Review;
import com.larcangeli.monolith.core.entity.implementation.ProductFactory;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import com.larcangeli.monolith.core.entity.interfaces.IReviewEntity;
import com.larcangeli.monolith.core.usecase.DTO.ProductAggregateDTO;
import com.larcangeli.monolith.core.usecase.DTO.RecommendationDTO;
import com.larcangeli.monolith.core.usecase.DTO.ReviewDTO;
import com.larcangeli.monolith.core.usecase.boundaries.input.CreationInputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.input.RemovalInputBoundary;
import com.larcangeli.monolith.core.usecase.boundaries.input.RetrievalInputBoundary;
import com.larcangeli.monolith.util.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductCompositeController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeController.class);

    private final CreationInputBoundary creationInputBoundary;
    private final RemovalInputBoundary removalInputBoundary;
    private final RetrievalInputBoundary retrievalInputBoundary;

    @Autowired
    public ProductCompositeController(CreationInputBoundary creationInputBoundary, RemovalInputBoundary removalInputBoundary, RetrievalInputBoundary retrievalInputBoundary) {
        this.creationInputBoundary = creationInputBoundary;
        this.removalInputBoundary = removalInputBoundary;
        this.retrievalInputBoundary = retrievalInputBoundary;
    }

    @GetMapping(value = "/product-composite/{productId}", produces = "application/json")
    ProductAggregateDTO getProduct(@PathVariable Long productId){

        LOG.debug("getCompositeProduct: lookup a product aggregate for productId: {}", productId);
        try{
            return retrievalInputBoundary.getProduct(productId);

        }catch (NotFoundException e){
            throw new NotFoundException("No product found with ID: " + productId);
        }
    }

    @GetMapping(value = "/product-composite", produces = "application/json")
    List<ProductAggregateDTO> getAllProducts(){
        return retrievalInputBoundary.getAllProducts();
    }

    @PostMapping(value    = "/product-composite", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ProductAggregateDTO createProduct(@RequestBody ProductAggregateDTO body){
        try{
            LOG.debug("createCompositeProduct: creates a new composite entity for productId: {}", body.productId());
            return creationInputBoundary.createProduct(body);

        }catch (RuntimeException re) {
            LOG.warn("createCompositeProduct failed", re);
            throw re;
        }
    }

    @DeleteMapping(value = "/product-composite/{productId}")
    void deleteProduct(@PathVariable Long productId){
        LOG.debug("deleteCompositeProduct: Deletes a product aggregate for productId: {}", productId);
        removalInputBoundary.deleteProduct(productId);

        LOG.debug("deleteCompositeProduct: aggregate entities deleted for productId: {}", productId);

    }

    @PostMapping(value = "/product-composite/recommendation", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    RecommendationDTO createRecommendation(@RequestBody RecommendationDTO recommendation){
        return creationInputBoundary.createRecommendation(recommendation);
    }

    @DeleteMapping(value = "/product-composite/recommendation/{recommendationId}")
    void deleteRecommendation(@PathVariable Long recommendationId){
        LOG.debug("deleteCompositeProduct: Deletes the recommendation with ID: {}", recommendationId);

        try{
            removalInputBoundary.deleteRecommendation(recommendationId);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Recommendation with ID: " + recommendationId + " not found");
        }
        LOG.debug("deleteCompositeProduct: recommendations deleted for ID: {}", recommendationId);

    }

    @PostMapping(value = "/product-composite/review", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ReviewDTO createReview(@RequestBody ReviewDTO review){
        return creationInputBoundary.createReview(review);
    }

    @DeleteMapping(value = "/product-composite/review/{reviewId}")
    void deleteReview(@PathVariable Long reviewId){
        LOG.debug("deleteCompositeProduct: Deletes the review with ID: {}", reviewId);

        try{
            removalInputBoundary.deleteReview(reviewId);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Recommendation with ID: " + reviewId + " not found");
        }
        LOG.debug("deleteCompositeProduct: recommendations deleted for ID: {}", reviewId);

    }


}
