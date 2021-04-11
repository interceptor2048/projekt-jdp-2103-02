package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CartRepository extends CrudRepository<Cart, Long> {
    @Override
    public List<Cart> findAll();

    @Override
    public Optional<Cart> findById(Long itemId);

    @Override
    public Cart save(Cart cart);

    @Override
    public void deleteById(Long cartId);
}
