package com.labs.java.module.product.service;

import com.labs.java.module.product.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private Map<Integer, Product> products = new HashMap<>();

    @Override
    public void createProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.replace(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }

    @Override
    public Product getProduct(int id) {
        return products.get(id);
    }
}
