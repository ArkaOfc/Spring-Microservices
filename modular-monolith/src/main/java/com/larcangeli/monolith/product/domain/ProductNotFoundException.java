package com.larcangeli.monolith.product.domain;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message) {
        super(message);
    }

    public static ProductNotFoundException forId(Long id) {
        return new ProductNotFoundException("Product with ID: " + id + " not found");
    }
}
