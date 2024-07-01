package com.larcangeli.monolith.web.controller;

import com.larcangeli.monolith.mapper.ReviewMapper;
import com.larcangeli.monolith.persistence.model.Review;
import com.larcangeli.monolith.service.IReviewService;
import com.larcangeli.monolith.web.dto.ReviewDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController{

    IReviewService reviewService;

    private final ReviewMapper mapper;

    public ReviewController(IReviewService reviewService, ReviewMapper mapper) {
        this.reviewService = reviewService;
        this.mapper = mapper;
    }

    @GetMapping(value = "/{id}")
    public ReviewDTO findById(@PathVariable Long id) {
        Review r = reviewService.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
        return mapper.reviewToReviewDTO(r);
    }

    @GetMapping
    public Collection<ReviewDTO> findAll() {
        Iterable<Review> allReviews = this.reviewService.findAll();
        List<ReviewDTO> reviewDTOs = new ArrayList<>();
        allReviews.forEach(p -> reviewDTOs.add(mapper.reviewToReviewDTO(p)));
        return reviewDTOs;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDTO create(@RequestBody ReviewDTO review) {
        Review entity = mapper.reviewDTOToReview(review);
        return mapper.reviewToReviewDTO(reviewService.save(entity));
    }
}
