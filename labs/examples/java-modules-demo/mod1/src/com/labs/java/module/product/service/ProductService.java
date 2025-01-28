package com.labs.java.module.product.service;

import com.labs.java.module.product.model.Product;

public interface ProductService {

    public void createProduct(Product product);
    public void updateProduct(int id, Product product);
    public void deleteProduct(int id);
    public Product getProduct(int id);
}
