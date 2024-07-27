package com.larcangeli.monolith.adapters.web.mapper;

import com.larcangeli.monolith.adapters.persistence.implementation.Product;
import com.larcangeli.monolith.core.entity.implementation.ProductEntity;
import com.larcangeli.monolith.core.entity.implementation.ReviewEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductEntity;
import com.larcangeli.monolith.core.entity.interfaces.IProductFactory;
import com.larcangeli.monolith.core.entity.interfaces.IRecommendationEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductAggregateMapper {
    Product productEntityToProductAggregate(IProductEntity productEntity);
    IProductEntity productAggregateToProductEntity(Product product);
    List<IProductEntity> productAggregatesToProductEntities(List<Product> products);
    List<Product> productEntitiesToProductAggregates(List<IProductEntity> productEntities);
}
