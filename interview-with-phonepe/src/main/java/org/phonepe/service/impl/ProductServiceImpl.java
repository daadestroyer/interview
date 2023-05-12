package org.phonepe.service.impl;

import org.phonepe.entity.Product;
import org.phonepe.repository.ProductRepository;
import org.phonepe.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void addProduct(Product product) {

        productRepository.addProduct(product);
    }

    public void removeProduct(String productId) throws Exception {
        Product product = productRepository.getProductById(productId);

        if (product == null) {
            throw new Exception("Product with ID " + productId + " not found.");
        }

        int quantity = product.getQuantity();

        if (quantity <= 0) {
            throw new Exception("Product with ID " + productId + " is out of stock.");
        }

        product.setQuantity(quantity - 1);
    }


    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}

