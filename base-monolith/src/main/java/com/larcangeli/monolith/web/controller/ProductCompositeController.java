package com.larcangeli.monolith.web.controller;

import com.larcangeli.monolith.mapper.ProductAggregateMapper;
import com.larcangeli.monolith.mapper.RecommendationMapper;
import com.larcangeli.monolith.mapper.ReviewMapper;
import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.persistence.model.Review;
import com.larcangeli.monolith.service.IProductCompositeService;
import com.larcangeli.monolith.util.exceptions.NotFoundException;
import com.larcangeli.monolith.web.dto.ProductAggregateDTO;
import com.larcangeli.monolith.web.dto.RecommendationDTO;
import com.larcangeli.monolith.web.dto.ReviewDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;

@RestController
public class ProductCompositeController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductCompositeController.class);

    private final ProductAggregateMapper productMapper;
    private final RecommendationMapper recommendationMapper;
    private final ReviewMapper reviewMapper;
    private final IProductCompositeService productService;

    @Autowired
    public ProductCompositeController(ProductAggregateMapper productMapper, RecommendationMapper recommendationMapper, ReviewMapper reviewMapper, IProductCompositeService productService) {
        this.productMapper = productMapper;
        this.recommendationMapper = recommendationMapper;
        this.reviewMapper = reviewMapper;
        this.productService = productService;
    }

    @GetMapping(value = "/product-composite/{productId}", produces = "application/json")
    ProductAggregateDTO getProduct(@PathVariable Long productId){

        LOG.debug("getCompositeProduct: lookup a product aggregate for productId: {}", productId);
        Optional<Product> p = productService.findById(productId);
        if(p.isEmpty()){
            throw new NotFoundException("No product found with ID: " + productId);
        }

        Set<Recommendation>     recommendations = productService.findRecommendationsByProductId(p.get().getProductId());
        Set<Review>             reviews = productService.findReviewsByProductId(p.get().getProductId());

        return createProductAggregate(p.get(), recommendations, reviews);
    }

    @GetMapping(value = "/product-composite", produces = "application/json")
    List<ProductAggregateDTO> getAllProducts(){
        Iterable<Product> allProducts = productService.findAll();
        List<ProductAggregateDTO> aggregates = new ArrayList<>();
        allProducts.forEach(p -> aggregates.add(createProductAggregate(p, productService.findRecommendationsByProductId(p.getProductId()), productService.findReviewsByProductId(p.getProductId()))));

        return aggregates;
    }

    @PostMapping(value    = "/product-composite", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ProductAggregateDTO createProduct(@RequestBody ProductAggregateDTO body){
        try{
            LOG.debug("createCompositeProduct: creates a new composite entity for productId: {}", body.productId());

            Set<Recommendation> recommendations = new HashSet<>();
            Set<Review> reviews = new HashSet<>();
            if (body.recommendations() != null) {
                recommendations = recommendationMapper.recommendationDTOsToRecommendations(body.recommendations());
            }
            if (body.reviews() != null) {
                reviews = reviewMapper.reviewDTOsToReviews(body.reviews());
            }

            Product p = new Product(recommendations, reviews, body.name(), body.weight(), body.version());

            LOG.debug("createCompositeProduct: composite entities created for productId: {}", body.productId());
            return productMapper.productAggregateToProductAggregateDTO(productService.save(p));

        }catch (RuntimeException re) {
            LOG.warn("createCompositeProduct failed", re);
            throw re;
        }
    }

    @DeleteMapping(value = "/product-composite/{productId}")
    void deleteProduct(@PathVariable Long productId){
        LOG.debug("deleteCompositeProduct: Deletes a product aggregate for productId: {}", productId);
        productService.deleteById(productId);

        LOG.debug("deleteCompositeProduct: aggregate entities deleted for productId: {}", productId);

    }

    @PostMapping(value = "/product-composite/recommendation", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    RecommendationDTO createRecommendation(@RequestBody RecommendationDTO recommendation){
        Optional<Product> p = productService.findById(recommendation.productId());
        if(p.isEmpty()){
            throw new NotFoundException("No product found with ID: " + recommendation.productId());
        }
        Recommendation r = new Recommendation(recommendation.productId(), recommendation.author(), recommendation.rating(), recommendation.content());
        productService.saveRecommendation(r);

        return recommendationMapper.recommendationToRecommendationDTO(r);
    }

    @DeleteMapping(value = "/product-composite/recommendation/{recommendationId}")
    void deleteRecommendation(@PathVariable Long recommendationId){
        LOG.debug("deleteCompositeProduct: Deletes the recommendation with ID: {}", recommendationId);

        try{
            productService.deleteRecommendation(recommendationId);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Recommendation with ID: " + recommendationId + " not found");
        }
        LOG.debug("deleteCompositeProduct: recommendations deleted for ID: {}", recommendationId);

    }

    @PostMapping(value = "/product-composite/review", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    ReviewDTO createReview(@RequestBody ReviewDTO review){
        Optional<Product> p = productService.findById(review.productId());
        if(p.isEmpty()){
            throw new NotFoundException("No product found with ID: " + review.productId());
        }
        Review r = new Review(review.productId(), review.author(), review.subject(), review.content());
        productService.saveReview(r);

        return reviewMapper.reviewToReviewDTO(r);
    }

    @DeleteMapping(value = "/product-composite/review/{reviewId}")
    void deleteReview(@PathVariable Long reviewId){
        LOG.debug("deleteCompositeProduct: Deletes the review with ID: {}", reviewId);

        try{
            productService.deleteReview(reviewId);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Recommendation with ID: " + reviewId + " not found");
        }
        LOG.debug("deleteCompositeProduct: recommendations deleted for ID: {}", reviewId);

    }

    private ProductAggregateDTO createProductAggregate(
            Product p,
            Set<Recommendation> recommendations,
            Set<Review> reviews){

        // 1. Setup product info
        Long productId = p.getProductId();
        String name = p.getName();
        int weight = p.getWeight();
        Integer version = p.getVersion();

        // 2. Copy summary recommendation info, if available
        List<RecommendationDTO> recommendationDTOs = (recommendations == null) ? null :
                recommendations.stream()
                        .map(r -> new RecommendationDTO(r.getRecommendationId(), r.getProductId(), r.getVersion(), r.getAuthor(), r.getRating(), r.getContent()))
                        .toList();

        // 3. Copy summary review info, if available
        List<ReviewDTO> reviewDTOs = (reviews == null) ? null :
                reviews.stream()
                        .map(r -> new ReviewDTO(r.getReviewId(), r.getProductId(), r.getAuthor(), r.getSubject(), r.getContent()))
                        .toList();

        return new ProductAggregateDTO(productId, version, name, weight, recommendationDTOs, reviewDTOs);
    }
}
