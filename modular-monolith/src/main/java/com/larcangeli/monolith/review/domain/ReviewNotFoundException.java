package com.larcangeli.monolith.review.domain;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String message) {
        super(message);
    }

    public static ReviewNotFoundException forId(Long id) {
        return new ReviewNotFoundException("Review with ID: " + id + " not found");
    }
}
