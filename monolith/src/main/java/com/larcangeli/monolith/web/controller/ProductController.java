package com.larcangeli.monolith.web.controller;

import com.larcangeli.monolith.mapper.ProductMapper;
import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.service.IProductService;
import com.larcangeli.monolith.web.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController{

    IProductService productService;

    private final ProductMapper mapper;

    public ProductController(IProductService productService, ProductMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        Product p = productService.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return mapper.productToProductDTO(p);
    }

    @GetMapping
    public Collection<ProductDTO> findAll() {
        Iterable<Product> allProducts = this.productService.findAll();
        List<ProductDTO> productDtos = new ArrayList<>();
        allProducts.forEach(p -> productDtos.add(mapper.productToProductDTO(p)));
        return productDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO create(@RequestBody ProductDTO product) {
        Product entity = mapper.productDTOToProduct(product);
        return mapper.productToProductDTO(productService.save(entity));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        productService.deleteById(id);
    }
}
