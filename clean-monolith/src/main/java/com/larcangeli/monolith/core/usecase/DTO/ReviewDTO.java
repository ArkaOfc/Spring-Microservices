package com.larcangeli.monolith.core.usecase.DTO;

public record ReviewDTO(Long reviewId,
                        Long productId,
                        String author,
                        String subject,
                        String content) {
}
