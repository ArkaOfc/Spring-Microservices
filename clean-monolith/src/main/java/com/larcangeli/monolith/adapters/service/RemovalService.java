package com.larcangeli.monolith.adapters.service;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.persistence.repository.IProductCompositeRepository;
import com.larcangeli.monolith.core.usecase.boundaries.output.RemovalOutputBoundary;
import com.larcangeli.monolith.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemovalService implements RemovalOutputBoundary {

    private final IProductCompositeRepository productRepository;

    public RemovalService(IProductCompositeRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> p = productRepository.findById(productId);
        if(p.isEmpty())
            throw new NotFoundException();
        p.get().deleteAllRecommendations();
        p.get().deleteAllReviews();
        productRepository.deleteById(productId);
    }

    @Override
    public void deleteRecommendation(Long recommendationId) {

    }

    @Override
    public void deleteReview(Long reviewId) {

    }
}
