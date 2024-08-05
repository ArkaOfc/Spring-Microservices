package com.larcangeli.monolith.review;

import java.util.List;

public interface IReviewService {

    ReviewDTO save(ReviewDTO review);

    void deleteById(Long reviewId);

    void deleteReviews(Long productId);

    List<ReviewDTO> findReviewsByProductId(Long productId);
}
