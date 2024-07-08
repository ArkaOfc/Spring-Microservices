package com.larcangeli.monolith.mapper;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.web.dto.ProductAggregateDTO;
import com.larcangeli.monolith.web.dto.RecommendationDTO;
import com.larcangeli.monolith.web.dto.ReviewDTO;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-08T15:59:49+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductAggregateMapperImpl implements ProductAggregateMapper {

    @Override
    public ProductAggregateDTO productAggregateToProductAggregateDTO(Product p) {
        if ( p == null ) {
            return null;
        }

        Long productId = null;
        Integer version = null;
        String name = null;
        int weight = 0;

        productId = p.getProductId();
        version = p.getVersion();
        name = p.getName();
        weight = p.getWeight();

        List<RecommendationDTO> recommendations = null;
        List<ReviewDTO> reviews = null;

        ProductAggregateDTO productAggregateDTO = new ProductAggregateDTO( productId, version, name, weight, recommendations, reviews );

        return productAggregateDTO;
    }

    @Override
    public Product productAggregateDTOToProductAggregate(ProductAggregateDTO pDTO) {
        if ( pDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductId( pDTO.productId() );
        product.setName( pDTO.name() );
        product.setWeight( pDTO.weight() );
        product.setVersion( pDTO.version() );

        return product;
    }
}
