package com.larcangeli.monolith.mapper;

import com.larcangeli.monolith.persistence.model.Recommendation;
import com.larcangeli.monolith.web.dto.RecommendationDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-01T16:32:33+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class RecommendationMapperImpl implements RecommendationMapper {

    @Override
    public RecommendationDTO recommendationToRecommendationDTO(Recommendation r) {
        if ( r == null ) {
            return null;
        }

        Integer version = null;
        String author = null;
        int rating = 0;
        String content = null;

        version = r.getVersion();
        author = r.getAuthor();
        rating = r.getRating();
        content = r.getContent();

        Long recommendationId = null;

        RecommendationDTO recommendationDTO = new RecommendationDTO( recommendationId, version, author, rating, content );

        return recommendationDTO;
    }

    @Override
    public Recommendation recommendationDTOToRecommendation(RecommendationDTO rDTO) {
        if ( rDTO == null ) {
            return null;
        }

        Recommendation recommendation = new Recommendation();

        recommendation.setVersion( rDTO.version() );
        recommendation.setAuthor( rDTO.author() );
        recommendation.setRating( rDTO.rating() );
        recommendation.setContent( rDTO.content() );

        return recommendation;
    }
}
