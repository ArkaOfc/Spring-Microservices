package com.larcangeli.monolith.product.domain;

import com.larcangeli.monolith.exceptions.InvalidInputException;
import com.larcangeli.monolith.product.IProductService;
import com.larcangeli.monolith.product.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDTO findById(Long id){
        if (id < 1) {
            throw new InvalidInputException("Invalid productId: " + id);
        }

        Product entity = productRepository.findById(id)
                .orElseThrow(() -> ProductNotFoundException.forId(id));
            return productMapper.productToProductDTO(entity);
    }


    public Collection<ProductDTO> findAll(){
        List<ProductDTO> products = new ArrayList<>();
        productRepository.findAll().forEach(p -> products.add(productMapper.productToProductDTO(p)));
        return products;
    }


    public ProductDTO save(ProductDTO product) {
        return productMapper.productToProductDTO(productRepository.save(productMapper.productDTOToProduct(product)));
    }


    public void deleteById(Long id) {
        productRepository.findById(id).ifPresent(productRepository::delete);
    }
}
