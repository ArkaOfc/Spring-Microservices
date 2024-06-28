package com.larcangeli.monolith.persistence.repository;

import com.larcangeli.monolith.persistence.model.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductRepositoryIntegrationTest {
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:latest"
    );

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    IProductRepository productRepository;

    @Test
    @Transactional
    void givenNewProject_whenSave_thenSuccess() {
        Product newProduct = new Product("Product 1", 10);

        Product saved = productRepository.save(newProduct);
        Optional<Product> fetchedProject = productRepository.findById(saved.getProductId());

        assertThat(fetchedProject).contains(newProduct);
    }

    @Test
    @Transactional
    void givenProjectCreated_whenUpdate_thenSuccess() {
        Product newProduct = new Product( "Product 1", 10, 1);
        Product saved = productRepository.save(newProduct);

        saved.setName("New Product 001");
        Product updated = productRepository.save(saved);

        Optional<Product> fetchedProduct = productRepository.findById(updated.getProductId());

        assertThat(fetchedProduct.isPresent()).isTrue();
        assertThat(fetchedProduct.get().getWeight()).isEqualTo(newProduct.getWeight());
        assertThat(fetchedProduct.get().getName()).isEqualTo("New Product 001");
        assertThat(fetchedProduct.get().getVersion()).isEqualTo(newProduct.getVersion());
    }

    @Test
    @Transactional
    void givenProjectCreated_whenFindByNameContaining_thenSuccess() {
        Product newProduct1 = new Product("Product Test 1", 10);
        Product newProduct2 = new Product("Product Test 2", 11);
        productRepository.save(newProduct1);
        productRepository.save(newProduct2);

        Iterable<Product> products = productRepository.findByNameContaining("Test");
        assertThat(products).contains(newProduct1, newProduct2);
    }

    @Test
    @Transactional
    void givenProjectCreated_whenDelete_thenSuccess() {
        Product newProject = new Product("Product Test 1", 10);
        Product saved = productRepository.save(newProject);
        productRepository.delete(newProject);

        Optional<Product> fetchedProduct = productRepository.findById(saved.getProductId());
        assertThat(fetchedProduct.isPresent()).isFalse();
    }

}
