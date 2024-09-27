package com.manager.products.service.iml;

import com.manager.products.model.CartItem;
import com.manager.products.model.Product;
import com.manager.products.repository.ICartProductRepository;
import com.manager.products.service.ICartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartProductService implements ICartProductService {
    @Autowired
    private ICartProductRepository cartProductRepository;

    @Override
    public void addProductToCart(Product product, int quantity) {
        CartItem existingCartProduct = cartProductRepository.findByProductId(product.getId());

        if (existingCartProduct != null) {
            existingCartProduct.setQuantity(existingCartProduct.getQuantity() + quantity);
            cartProductRepository.save(existingCartProduct);
        } else {
            CartItem newCartProduct = new CartItem();
            newCartProduct.setProduct(product);
            newCartProduct.setQuantity(quantity);
            cartProductRepository.save(newCartProduct);
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        cartProductRepository.deleteById(productId);
    }
}
