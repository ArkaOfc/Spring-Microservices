package com.larcangeli.monolith.controller;

import com.larcangeli.monolith.persistence.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(value = "/products")
public interface IProductController {

    @GetMapping(value = "/{product_id}")
    Product findById(@PathVariable Long product_id);

    @GetMapping
    Collection<Product> findAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Product create(@RequestBody Product product);
}
