package org.phonepe.repository;

import org.phonepe.entity.Product;

import java.util.List;

public interface ProductRepository {
    void addProduct(Product product);
    void removeProduct(String productId);
    Product getProductById(String productId);
    List<Product> getAllProducts();
}

