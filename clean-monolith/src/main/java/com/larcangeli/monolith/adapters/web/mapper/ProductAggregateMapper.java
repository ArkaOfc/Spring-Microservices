package com.larcangeli.monolith.adapters.web.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.adapters.web.mapper.dto.ProductAggregateDTO;
import com.larcangeli.monolith.adapters.web.mapper.dto.ReviewDTO;
import com.larcangeli.monolith.core.entity.implementation.ProductEntity;
import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RecommendationMapper.class, ReviewMapper.class})
public interface ProductAggregateMapper {
    ProductAggregateDTO productAggregateToProductAggregateDTO(Product p);
    Product productAggregateDTOToProductAggregate(ProductAggregateDTO pDTO);
    IProductEntity productAggregateDTOToProductEntity(ProductAggregateDTO pDTO);
    ProductAggregateDTO productEntityToProductAggregateDTO(IProductEntity p);
}
