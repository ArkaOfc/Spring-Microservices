package com.larcangeli.monolith.mapper;

import com.larcangeli.monolith.persistence.model.Review;
import com.larcangeli.monolith.web.dto.ReviewDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-01T16:32:33+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewDTO reviewToReviewDTO(Review r) {
        if ( r == null ) {
            return null;
        }

        Long reviewId = null;
        String author = null;
        String subject = null;
        String content = null;

        reviewId = r.getReviewId();
        author = r.getAuthor();
        subject = r.getSubject();
        content = r.getContent();

        ReviewDTO reviewDTO = new ReviewDTO( reviewId, author, subject, content );

        return reviewDTO;
    }

    @Override
    public Review reviewDTOToReview(ReviewDTO rDTO) {
        if ( rDTO == null ) {
            return null;
        }

        Review review = new Review();

        review.setReviewId( rDTO.reviewId() );
        review.setAuthor( rDTO.author() );
        review.setSubject( rDTO.subject() );
        review.setContent( rDTO.content() );

        return review;
    }
}
