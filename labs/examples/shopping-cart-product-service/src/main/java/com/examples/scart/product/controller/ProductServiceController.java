package com.examples.scart.product.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examples.scart.product.model.Product;
import com.examples.scart.product.service.ProductService;

@RestController
//@RequestMapping("/")
@RequestMapping("/products")
public class ProductServiceController {
//   private static Map<String, Product> productRepo = new HashMap<>();
   private static Logger log = LoggerFactory.getLogger(ProductServiceController.class);
   
   @Autowired
   ProductService productService;
   
   
//   static {
//      Product mobile = new Product();
//      mobile.setId("1");
//      mobile.setName("Samsung Galaxy Note10");      
//      mobile.setCategory("Mobiles");
//      mobile.setManufacturer("Samsung");
//      productRepo.put(mobile.getId(), mobile);
//      
//      Product laptop = new Product();
//      laptop.setId("2");
//      laptop.setName("Lenovo Thinkpad E490");
//      laptop.setCategory("Laptops");
//      laptop.setManufacturer("Samsung");      
//      productRepo.put(laptop.getId(), laptop);
//   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
//      productRepo.remove(id);
	   
	   productService.deleteProduct(id);
	   
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
//      productRepo.remove(id);
//      product.setId(id);
//      productRepo.put(id, product);
	   
	   productService.updateProduct(id, product);
	   
      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
   }
   
   @PostMapping
   public ResponseEntity<String> createProduct(@RequestBody Product product)  {
	   
//      productRepo.put(product.getId(), product);
	   
	   productService.createProduct(product);
	   
      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
   }
   
   @GetMapping
   public ResponseEntity<Object> getProduct() throws InterruptedException {
	  log.info("Received request to list products...");

	  
//      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	  
	  return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
   }
}
