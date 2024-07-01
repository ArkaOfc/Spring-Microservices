package com.larcangeli.monolith.web.controller;

import com.larcangeli.monolith.mapper.RecommendationMapper;
import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.service.IRecommendationService;
import com.larcangeli.monolith.web.dto.RecommendationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/recommendations")
public class RecommendationController{
    IRecommendationService recommendationService;

    private final RecommendationMapper mapper;

    public RecommendationController(IRecommendationService recommendationService, RecommendationMapper mapper) {
        this.recommendationService = recommendationService;
        this.mapper = mapper;
    }

    @GetMapping(value = "/{id}")
    public RecommendationDTO findById(@PathVariable Long id) {
        Recommendation r = recommendationService.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
        return mapper.recommendationToRecommendationDTO(r);
    }

    @GetMapping
    public Collection<RecommendationDTO> findAll() {
        Iterable<Recommendation> allRecommendations = this.recommendationService.findAll();
        List<RecommendationDTO> recommendationDTOs = new ArrayList<>();
        allRecommendations.forEach(p -> recommendationDTOs.add(mapper.recommendationToRecommendationDTO(p)));
        return recommendationDTOs;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecommendationDTO create(@RequestBody RecommendationDTO recommendation) {
        Recommendation entity = mapper.recommendationDTOToRecommendation(recommendation);
        return mapper.recommendationToRecommendationDTO(recommendationService.save(entity));

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        recommendationService.deleteById(id);
    }
}
