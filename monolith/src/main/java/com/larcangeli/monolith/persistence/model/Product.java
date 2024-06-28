package com.larcangeli.monolith.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.Version;

/*postgres: port 5432, admin admin*/
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Version
    private Integer version;
    private String name;
    private int weight;

    public Product() {
        name = null;
        weight = 0;
    }

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Product(String name, int weight, Integer version) {
        this.name = name;
        this.weight = weight;
        this.version = version;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
