package com.larcangeli.monolith.service.impl;

import com.larcangeli.monolith.persistence.model.Product;
import com.larcangeli.monolith.persistence.repository.IProductRepository;
import com.larcangeli.monolith.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {
    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Long id){return productRepository.findById(id);}
    @Override
    public Collection<Product> findAll(){
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }


}
