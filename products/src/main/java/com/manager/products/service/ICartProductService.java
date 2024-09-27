package com.manager.products.service;

import com.manager.products.model.Product;

public interface ICartProductService {
    void addProductToCart(Product product, int quantity);

    void deleteProduct(Long productId);
}
