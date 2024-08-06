package com.larcangeli.monolith.product.domain;

import com.larcangeli.monolith.exceptions.InvalidInputException;
import com.larcangeli.monolith.product.shared.IProductService;
import com.larcangeli.monolith.product.shared.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
class ProductService implements IProductService {

    private final ProductRepository repo;
    private final ProductMapper mapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.repo = productRepository;
        this.mapper = productMapper;
    }

    public ProductDTO findById(Long id){
        if (id < 1) {
            throw new InvalidInputException("Invalid productId: " + id);
        }

        Product entity = repo.findById(id)
                .orElseThrow(() -> ProductNotFoundException.forId(id));
            return mapper.toDTO(entity);
    }


    public Collection<ProductDTO> findAll(){
        List<ProductDTO> products = new ArrayList<>();
        repo.findAll().forEach(p -> products.add(mapper.toDTO(p)));
        return products;
    }


    public ProductDTO save(ProductDTO product) {
        return mapper.toDTO(repo.save(mapper.toEntity(product)));
    }


    public void deleteById(Long id) {
        repo.findById(id).ifPresent(repo::delete);
    }
}
