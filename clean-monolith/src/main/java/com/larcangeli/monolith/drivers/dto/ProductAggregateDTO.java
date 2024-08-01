package com.larcangeli.monolith.drivers.dto;

import java.util.List;

public record ProductAggregateDTO(Long productId,
                                  Integer version,
                                  String name,
                                  int weight, 
                                  List<RecommendationDTO> recommendations,
                                  List<ReviewDTO> reviews
                                  ) {
}