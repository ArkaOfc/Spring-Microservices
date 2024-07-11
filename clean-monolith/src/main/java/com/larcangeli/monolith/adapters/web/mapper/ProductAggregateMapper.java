package com.larcangeli.monolith.adapters.web.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductAggregateMapper {
    ProductAggregateDTO productAggregateToProductAggregateDTO(Product p);
    Product productAggregateDTOToProductAggregate(ProductAggregateDTO pDTO);
}
