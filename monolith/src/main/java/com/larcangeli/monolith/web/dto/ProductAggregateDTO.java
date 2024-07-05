package com.larcangeli.monolith.web.dto;

import java.util.List;

public record ProductAggregateDTO(Long productId,
                                  String name,
                                  int weight, 
                                  List<RecommendationDTO> recommendations,
                                  List<ReviewDTO> reviews
                                  ) {
}
