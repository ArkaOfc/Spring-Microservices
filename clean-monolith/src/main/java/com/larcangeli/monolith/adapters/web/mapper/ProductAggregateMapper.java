package com.larcangeli.monolith.adapters.web.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.core.entity.implementation.ProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.usecase.DTO.ProductAggregateDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductAggregateMapper {

    Product productEntityToProductAggregate(IProductEntity productEntity);
    ProductEntity productAggregateToProductEntity(Product product);
    List<ProductEntity> productAggregatesToProductEntities(List<Product> products);
    List<Product> productEntitiesToProductAggregates(List<IProductEntity> productEntities);
    ProductAggregateDTO productEntityToProductDTO(IProductEntity productEntities);
    ProductEntity productDTOToProductEntity(ProductAggregateDTO product);
}
