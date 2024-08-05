package com.larcangeli.monolith.product.domain;

import com.larcangeli.monolith.product.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface ProductMapper {
    ProductDTO productToProductDTO(Product p);
    Product productDTOToProduct(ProductDTO pDTO);
}
