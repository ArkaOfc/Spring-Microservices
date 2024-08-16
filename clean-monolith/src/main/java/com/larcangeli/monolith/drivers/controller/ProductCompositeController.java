package com.larcangeli.monolith.drivers.controller;

import com.larcangeli.monolith.drivers.dto.ProductAggregateDTO;
import com.larcangeli.monolith.drivers.dto.RecommendationDTO;
import com.larcangeli.monolith.drivers.dto.ReviewDTO;
import com.larcangeli.monolith.core.usecase.creation.CreationInputBoundary;
import com.larcangeli.monolith.core.usecase.removal.RemovalInputBoundary;
import com.larcangeli.monolith.core.usecase.retrieval.RetrievalInputBoundary;
import com.larcangeli.monolith.drivers.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.drivers.mapper.RecommendationMapper;
import com.larcangeli.monolith.drivers.mapper.ReviewMapper;
import com.larcangeli.monolith.drivers.util.exceptions.NotFoundException;
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
    private final ProductAggregateMapper productMapper;
    private final RecommendationMapper recommendationMapper;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ProductCompositeController(CreationInputBoundary creationInputBoundary, RemovalInputBoundary removalInputBoundary, RetrievalInputBoundary retrievalInputBoundary, ProductAggregateMapper productMapper, RecommendationMapper recommendationMapper, ReviewMapper reviewMapper) {
        this.creationInputBoundary = creationInputBoundary;
        this.removalInputBoundary = removalInputBoundary;
        this.retrievalInputBoundary = retrievalInputBoundary;
        this.productMapper = productMapper;
        this.recommendationMapper = recommendationMapper;
        this.reviewMapper = reviewMapper;
    }

    @GetMapping(value = "/product-composite/{productId}", produces = "application/json")
    ProductAggregateDTO getProduct(@PathVariable Long productId){

        LOG.debug("getCompositeProduct: lookup a product aggregate for productId: {}", productId);
        try{
            return productMapper.entityToDto(retrievalInputBoundary.getProduct(productId));

        }catch (NotFoundException e){
            throw new NotFoundException("No product found with ID: " + productId);
        }
    }

    @GetMapping(value = "/product-composite", produces = "application/json")
    List<ProductAggregateDTO> getAllProducts(){
        return retrievalInputBoundary.getAllProducts().stream().map(productMapper::entityToDto).toList();
    }

    @PostMapping(value    = "/product-composite", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ProductAggregateDTO createProduct(@RequestBody ProductAggregateDTO request){
        try{
            LOG.debug("createCompositeProduct: creates a new composite entity for productId: {}", request.productId());
            return productMapper.entityToDto(creationInputBoundary.createProduct(productMapper.dtoToEntity(request)));

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

    @PostMapping(value = "/product-composite/{productId}/recommendations", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    RecommendationDTO createRecommendation(@PathVariable Long productId, @RequestBody RecommendationDTO recommendation){
        return recommendationMapper.entityToDto(creationInputBoundary.createRecommendation(recommendationMapper.dtoToEntity(recommendation)));
    }

    @DeleteMapping(value = "/product-composite/{productId}/recommendations/{recommendationId}")
    void deleteRecommendation(@PathVariable Long productId, @PathVariable Long recommendationId){
        LOG.debug("deleteCompositeProduct: Deletes the recommendation with ID: {}", recommendationId);

        try{
            removalInputBoundary.deleteRecommendation(productId, recommendationId);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Recommendation with ID: " + recommendationId + " not found");
        }
        LOG.debug("deleteCompositeProduct: recommendations deleted for ID: {}", recommendationId);

    }

    @PostMapping(value = "/product-composite/{productId}/reviews", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ReviewDTO createReview(@PathVariable Long productId, @RequestBody ReviewDTO review){
        return reviewMapper.entityToDto(creationInputBoundary.createReview(reviewMapper.dtoToEntity(review)));
    }

    @DeleteMapping(value = "/product-composite/{productId}/reviews/{reviewId}")
    void deleteReview(@PathVariable Long productId, @PathVariable Long reviewId){
        LOG.debug("deleteCompositeProduct: Deletes the review with ID: {}", reviewId);

        try{
            removalInputBoundary.deleteReview(productId, reviewId);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Recommendation with ID: " + reviewId + " not found");
        }
        LOG.debug("deleteCompositeProduct: recommendations deleted for ID: {}", reviewId);

    }


}
