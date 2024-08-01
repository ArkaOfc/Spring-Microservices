package com.larcangeli.monolith.drivers.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.core.entity.product.impl.ProductEntity;
import com.larcangeli.monolith.core.entity.product.IProductEntity;
import com.larcangeli.monolith.drivers.dto.ProductAggregateDTO;
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
