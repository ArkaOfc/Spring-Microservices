package com.larcangeli.monolith.adapters.web.mapper.dto;

public record ReviewDTO(Long reviewId, Long productId, String author, String subject, String content) {
}
