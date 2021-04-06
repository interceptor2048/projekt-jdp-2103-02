package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Override
    public List<Product> findAll();

    @Override
    public Optional<Product> findById(Long productId);

    @Override
    public Product save(Product product);

    @Override
    public void deleteById(Long productId);
}
