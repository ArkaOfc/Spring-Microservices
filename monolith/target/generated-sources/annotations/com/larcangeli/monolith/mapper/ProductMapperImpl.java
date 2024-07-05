package com.larcangeli.monolith.mapper;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.web.dto.ProductDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-05T16:20:19+0200",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product p) {
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

        ProductDTO productDTO = new ProductDTO( productId, version, name, weight );

        return productDTO;
    }

    @Override
    public Product productDTOToProduct(ProductDTO pDTO) {
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
