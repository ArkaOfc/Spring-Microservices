package com.larcangeli.monolith.product;

import com.larcangeli.monolith.recommendation.RecommendationDTO;
import com.larcangeli.monolith.review.ReviewDTO;

import java.util.List;

public record ProductDTO(Long productId,
                                  Integer version,
                                  String name,
                                  int weight,
                                  List<RecommendationDTO> recommendations,
                                  List<ReviewDTO> reviews
) {
}
