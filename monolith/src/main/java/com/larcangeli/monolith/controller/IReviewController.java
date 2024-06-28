package com.larcangeli.monolith.controller;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(value = "/reviews")
public interface IReviewController {
    @GetMapping(value = "/{review_id}")
    Review findById(@PathVariable Long review_id);

    @GetMapping
    Collection<Review> findAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Review create(@RequestBody Review review);
}
