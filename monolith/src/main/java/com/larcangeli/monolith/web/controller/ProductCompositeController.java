package com.larcangeli.monolith.web.controller;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.persistence.model.Review;
import com.larcangeli.monolith.service.IProductService;
import com.larcangeli.monolith.service.IRecommendationService;
import com.larcangeli.monolith.service.IReviewService;
import com.larcangeli.monolith.util.exceptions.NotFoundException;
import com.larcangeli.monolith.web.dto.ProductAggregateDTO;
import com.larcangeli.monolith.web.dto.RecommendationDTO;
import com.larcangeli.monolith.web.dto.ReviewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductCompositeController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeController.class);

    private final IProductService productService;
    private final IRecommendationService recommendationService;
    private final IReviewService reviewService;

    @Autowired
    public ProductCompositeController(IProductService productService, IRecommendationService recommendationService, IReviewService reviewService) {
        this.productService = productService;
        this.recommendationService = recommendationService;
        this.reviewService = reviewService;
    }

    @GetMapping(value = "/product-composite/{productId}", produces = "application/json")
    ProductAggregateDTO getProduct(@PathVariable Long productId){

        LOG.debug("getCompositeProduct: lookup a product aggregate for productId: {}", productId);
        Optional<Product> p = productService.findById(productId);
        if(p.isEmpty()){
            throw new NotFoundException("No product found with ID: " + productId);
        }

        List<Recommendation>    recommendations = recommendationService.findAllByProduct(p.get());
        List<Review>            reviews = reviewService.findAllByProduct(p.get());

        return createProductAggregate(p.get(), recommendations, reviews);


    }

    @PostMapping(value    = "/product-composite", consumes = "application/json")
    void createProduct(@RequestBody ProductAggregateDTO body){
        try{
            LOG.debug("createCompositeProduct: creates a new composite entity for productId: {}", body.productId());

            Product p = new Product(body.name(), body.weight());
            productService.save(p);

            if (body.recommendations() != null) {
                body.recommendations().forEach(r -> {
                    Recommendation recommendation = new Recommendation(p, r.author(), r.rating(), r.content());
                    recommendationService.save(recommendation);
                });
            }

            if (body.reviews() != null) {
                body.reviews().forEach(r -> {
                    Review review = new Review(p, r.author(), r.subject(), r.content());
                    reviewService.save(review);
                });
            }

            LOG.debug("createCompositeProduct: composite entities created for productId: {}", body.productId());

        }catch (RuntimeException re) {
            LOG.warn("createCompositeProduct failed", re);
            throw re;
        }
    }

    @DeleteMapping(value = "/product-composite/{productId}")
    void deleteProduct(@PathVariable Long productId){
        LOG.debug("deleteCompositeProduct: Deletes a product aggregate for productId: {}", productId);

        reviewService.deleteAllByProduct(productService.findById(productId).get());

        recommendationService.deleteAllByProduct(productService.findById(productId).get());

        productService.deleteById(productId);

        LOG.debug("deleteCompositeProduct: aggregate entities deleted for productId: {}", productId);

    }

    private ProductAggregateDTO createProductAggregate(
            Product p,
            List<Recommendation> recommendations,
            List<Review> reviews){

        // 1. Setup product info
        Long productId = p.getProductId();
        String name = p.getName();
        int weight = p.getWeight();

        // 2. Copy summary recommendation info, if available
        List<RecommendationDTO> recommendationDTOs = (recommendations == null) ? null :
                recommendations.stream()
                        .map(r -> new RecommendationDTO( r.getRecommendationId(), r.getVersion(), r.getAuthor(), r.getRating(), r.getContent()))
                        .toList();

        // 3. Copy summary review info, if available
        List<ReviewDTO> reviewDTOs = (reviews == null) ? null :
                reviews.stream()
                        .map(r -> new ReviewDTO(r.getReviewId(), r.getAuthor(), r.getSubject(), r.getContent()))
                        .toList();

        return new ProductAggregateDTO(productId, name, weight, recommendationDTOs, reviewDTOs);
    }
}
