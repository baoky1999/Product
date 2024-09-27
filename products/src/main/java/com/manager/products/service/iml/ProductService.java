package com.manager.products.service.iml;

import com.manager.products.model.Product;
import com.manager.products.repository.IProductRepository;
import com.manager.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    public List<Product> findAll(Long sizeId, Double price, Long colorId, Long categoryId) {
        if (sizeId == null && price == null && colorId == null && categoryId == null) {
            return productRepository.findAll();
        }
        return productRepository.findByCriteria(sizeId, price, colorId, categoryId);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
