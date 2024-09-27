package com.manager.products.repository;

import com.manager.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p " +
            "WHERE (:sizeId IS NULL OR p.size.id = :sizeId) " +
            "AND (:price IS NULL OR p.price <= :price) " +
            "AND (:colorId IS NULL OR p.color.id = :colorId) " +
            "AND (:categoryId IS NULL OR p.category.id = :categoryId)")
    List<Product> findByCriteria(@Param("sizeId") Long sizeId,
                                 @Param("price") Double price,
                                 @Param("colorId") Long colorId,
                                 @Param("categoryId") Long categoryId);
}
