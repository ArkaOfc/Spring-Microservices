package com.larcangeli.monolith.controller.impl;

import com.larcangeli.monolith.controller.IProductController;
import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ProductController implements IProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public Product findById(Long product_id) {
        return productService.findById(product_id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.BAD_REQUEST)
        );
    }

    @Override
    public Collection<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public Product create(Product product) {
        return productService.save(product);
    }
}
