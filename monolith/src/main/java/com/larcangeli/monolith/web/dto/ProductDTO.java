package com.larcangeli.monolith.web.dto;

public record ProductDTO(
        Long productId,
        Integer version,
        String name,
        int weight) {
}
