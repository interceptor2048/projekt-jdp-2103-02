package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
public class ProductDbService {
    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(final Long productId) {
        return repository.findById(productId).orElse(null);
    }

    public Product save(final Product product) {
        return repository.save(product);
    }

    public void deleteProductById(final Long productId) {
        repository.deleteById(productId);
    }
}
