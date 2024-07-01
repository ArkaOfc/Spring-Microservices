package com.larcangeli.monolith.mapper;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.web.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO productToProductDTO(Product p);
    Product productDTOToProduct(ProductDTO pDTO);
}
