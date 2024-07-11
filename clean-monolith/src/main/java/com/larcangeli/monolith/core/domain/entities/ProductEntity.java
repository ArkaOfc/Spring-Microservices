package com.larcangeli.monolith.core.domain.entities;

import com.larcangeli.monolith.core.interfaces.IProductEntity;

public class ProductEntity implements IProductEntity {

    Long id;
    Integer version;
    String name;
    int weight;

    public ProductEntity(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public ProductEntity(Integer version, String name, int weight) {
        this.version = version;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Integer getVersion() {
        return this.version;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}
