package com.examples.junit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.examples.junit.model.Product;

public class ProductService {

    private static Map<String, Product> productRepo = new HashMap<>();

    public Collection<Product> getProducts() {
        return productRepo.values();
    }

    public void createProduct(Product product) {
        if(product.getId() == null || product.getId().isEmpty()) {
            throw new RuntimeException("Product Id mandatory");
        }
        productRepo.put(product.getId(), product);
    }

    public void updateProduct(String id, Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.put(id, product);
    }

    public void deleteProduct(String id) {
        productRepo.remove(id);
    }

    public Product getProduct(String id) {
        return productRepo.get(id);
    }

    public void clear() {
        productRepo.clear();
    }

}