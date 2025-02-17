package com.examples.scart.product.service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.scart.product.model.Product;
import com.examples.scart.product.repository.ProductRepository;

@Service
public class ProductService {

//    private static Map<String, Product> productRepo = new HashMap<>();

    @Autowired
    ProductRepository productRepo;

    public Collection<Product> getProducts() {
//        return productRepo.values();
        return productRepo.findAll();
    }

    public String createProduct(Product product) {
        if(product.getId() == null || product.getId().isEmpty()) {
            throw new RuntimeException("Product Id mandatory");
        }
//        productRepo.put(product.getId(), product);
        productRepo.save(product);
        return "Product created";
    }

    public void updateProduct(String id, Product product) {
//        productRepo.remove(id);
//        product.setId(id);
//        productRepo.put(id, product);
        product.setId(id);
        productRepo.save(product);
    }

    public void deleteProduct(String id) {
//        productRepo.remove(id);
//    	System.out.println("Product: " + productRepo.findById(id).get().getId());
//        productRepo.delete(productRepo.findById(id).get());
        productRepo.deleteById(id);
    }

    public Product getProduct(String id) {
//        return productRepo.get(id);
    	Optional<Product> product = productRepo.findById(id);
        return product.isPresent() ? product.get() : null;
    }

    public void clear() {
//        productRepo.clear();
    	productRepo.deleteAll();    	
    }

}