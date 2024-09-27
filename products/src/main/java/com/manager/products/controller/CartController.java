package com.manager.products.controller;

import com.manager.products.model.Product;
import com.manager.products.service.ICartProductService;
import com.manager.products.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private ICartProductService cartProductService;

    @Autowired
    private IProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProductToCart(@RequestParam Long productId, @RequestParam int quantity) {
        Product product = productService.findById(productId);
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        cartProductService.addProductToCart(product, quantity);
        return new ResponseEntity<>("Product added to cart", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeProductFromCart(@RequestParam Long productId) {
        Product product = productService.findById(productId);
        if (product == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        cartProductService.deleteProduct(productId);
        return new ResponseEntity<>("Product removed from cart", HttpStatus.OK);
    }
}
