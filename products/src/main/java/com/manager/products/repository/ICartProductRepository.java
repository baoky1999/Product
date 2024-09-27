package com.manager.products.repository;

import com.manager.products.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartProductRepository extends JpaRepository<CartItem, Long> {
    CartItem findByProductId(Long id);
}
