package com.larcangeli.monolith.product.web.controllers;

import com.larcangeli.monolith.product.ProductDTO;
import com.larcangeli.monolith.product.IProductService;
import com.larcangeli.monolith.recommendation.IRecommendationService;
import com.larcangeli.monolith.recommendation.RecommendationDTO;
import com.larcangeli.monolith.review.IReviewService;
import com.larcangeli.monolith.review.ReviewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    private final IProductService productService;
    private final IRecommendationService recommendationService;
    private final IReviewService reviewService;

    @Autowired
    public ProductController(IProductService productService, IRecommendationService recommendationService, IReviewService reviewService) {
        this.productService = productService;
        this.recommendationService = recommendationService;
        this.reviewService = reviewService;
    }


    @GetMapping(value = "/product-composite/{productId}", produces = "application/json")
    ProductDTO getProduct(@PathVariable Long productId){
        LOG.debug("getCompositeProduct: lookup a product aggregate for productId: {}", productId);
        ProductDTO p = productService.findById(productId);

        List<RecommendationDTO> recommendations = recommendationService.findRecommendationsByProductId(productId);
        List<ReviewDTO> reviews = reviewService.findReviewsByProductId(productId);

        return createProductAggregate(p,recommendations,reviews);
    }

    @GetMapping(value = "/product-composite", produces = "application/json")
    List<ProductDTO> getAllProducts(){
        //List<ProductDTO> aggregates = new ArrayList<>();

        return productService.findAll().stream().map(p -> getProduct(p.productId())).collect(Collectors.toList());

        /*productService.findAll().stream().toList().forEach(p -> {
            List<RecommendationDTO> recommendations = recommendationService.findRecommendationsByProductId(p.productId());
            List<ReviewDTO> reviews = reviewService.findReviewsByProductId(p.productId());
            aggregates.add(createProductAggregate(p, recommendations, reviews));
        });

        return aggregates;*/
    }

    @PostMapping(value    = "/product-composite", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ProductDTO createProduct(@RequestBody ProductDTO body){
        try{
            LOG.debug("createCompositeProduct: creates a new composite entity for productId: {}", body.productId());
            ProductDTO p = productService.save(body);
            if(!body.recommendations().isEmpty()){
                body.recommendations().forEach(recommendationService::save);
            }
            if(!body.reviews().isEmpty()){
                body.reviews().forEach(reviewService::save);
            }
            LOG.debug("createCompositeProduct: composite entities created for productId: {}", body.productId());
            return p;

        }catch (RuntimeException re) {
            LOG.warn("createCompositeProduct failed", re);
            throw re;
        }
    }

    @DeleteMapping(value = "/product-composite/{productId}")
    void deleteProduct(@PathVariable Long productId){
        LOG.debug("deleteCompositeProduct: Deletes a product aggregate for productId: {}", productId);
        productService.deleteById(productId);
        recommendationService.deleteRecommendations(productId);
        reviewService.deleteReviews(productId);
        LOG.debug("deleteCompositeProduct: aggregate entities deleted for productId: {}", productId);

    }

    private ProductDTO createProductAggregate(
            ProductDTO p,
            List<RecommendationDTO> recommendations,
            List<ReviewDTO> reviews){

        // 1. Setup product info
        Long productId = p.productId();
        String name = p.name();
        int weight = p.weight();
        Integer version = p.version();

        // 2. Copy summary recommendation info, if available
        return new ProductDTO(productId, version, name, weight, recommendations, reviews);
    }
}

