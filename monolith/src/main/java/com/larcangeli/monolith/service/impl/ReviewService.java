package com.larcangeli.monolith.service.impl;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Review;
import com.larcangeli.monolith.persistence.repository.IReviewRepository;
import com.larcangeli.monolith.service.IReviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements IReviewService {
    private IReviewRepository reviewRepository;

    public ReviewService(IReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> findById(Long id){return reviewRepository.findById(id);}

    @Override
    public Collection<Review> findAll(){
        List<Review> reviews = new ArrayList<>();
        reviewRepository.findAll().forEach(reviews::add);
        return reviews;
    }
    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAllByProduct(Product product) {
        return reviewRepository.findAllByProduct(product);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
    @Override
    public void deleteAllByProduct(Product product) {
        reviewRepository.deleteAllByProduct(product);
    }



}
