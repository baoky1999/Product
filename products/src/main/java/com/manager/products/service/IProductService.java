package com.manager.products.service;

import com.manager.products.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll(Long sizeId, Double price, Long colorId, Long categoryId);

    Product findById(Long id);
}
