package com.larcangeli.monolith.controller;

import com.larcangeli.monolith.persistence.model.Recommendation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@RequestMapping(value = "/recommendations")
public interface IRecommendationController {
    @GetMapping(value = "/{recommendation_id}")
    Recommendation findById(@PathVariable Long recommendation_id);

    @GetMapping
    Collection<Recommendation> findAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Recommendation create(@RequestBody Recommendation recommendation);
}
