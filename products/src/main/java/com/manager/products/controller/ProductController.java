package com.manager.products.controller;

import com.manager.products.model.Product;
import com.manager.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(
            @RequestParam(value = "sizeId", required = false) Long sizeId,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "colorId", required = false) Long colorId,
            @RequestParam(value = "categoryId", required = false) Long categoryId) {

        List<Product> products = productService.findAll(sizeId, price, colorId, categoryId);

        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


}
