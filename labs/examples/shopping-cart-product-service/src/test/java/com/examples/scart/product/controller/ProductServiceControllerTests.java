package com.examples.scart.product.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import com.examples.scart.product.model.Product;
import com.examples.scart.product.service.ProductService;

// API Test / Integration test
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceControllerTests {

    @Autowired
    TestRestTemplate restTemp;

    @MockBean
//    @Autowired
    ProductService productService;

    private static List<Product> products = new ArrayList<>();

    @BeforeEach
    public void setup() {
        // Initialize Test data
        Product mobile = new Product();
        mobile.setId("1");
        mobile.setName("Samsung Galaxy Note10");
        mobile.setCategory("Mobiles");
        mobile.setManufacturer("Samsung");
        products.add(mobile);
//        productService.createProduct(mobile);

        Product laptop = new Product();
        laptop.setId("2");
        laptop.setName("Lenovo Thinkpad E490");
        laptop.setCategory("Laptops");
        laptop.setManufacturer("Lenovo");
        products.add(laptop);
//        productService.createProduct(laptop);
    }

    @AfterEach
    public void cleanup() {
//        productService.clear();
    	products.clear();
    }

    @Test
    public void shouldCreateProduct() throws URISyntaxException
    {
        // POST /products

    
        Mockito.when(productService.createProduct(new Product())).thenReturn("Product is created successfully");

        String reqBody = "{\"id\":\"1\",\"name\":\"HP Deskjet 5600\",\"category\":\"Printer\",\"manufacturer\":\"HP\"}";


        // Step 1: Create Request
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/products"));
//        RequestEntity request = new RequestEntity(reqBody, headers, HttpMethod.POST, new URI("/"));


        // Step 2: Send Request to Endpoint
        // Step 3: Receive the Response

        ResponseEntity<String> response = restTemp.exchange(request, String.class);

        System.out.println("Response: " + response.getBody());

        // Step 4: Validate the Response
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.getBody()).isEqualTo("Product is created successfully");
    }


    @Test
    public void shouldReturnAllProducts() {

        Mockito.when(productService.getProducts()).thenReturn(products);

        // REST Template
        // Step 1: Create Request
        // Step 2: Send Request to Endpoint
        // Step 3: Receive the Response
        ResponseEntity<Object> response = restTemp.getForEntity("/products", Object.class);
//        ResponseEntity<Object> response = restTemp.getForEntity("/", Object.class);


        List<Product> products = (List) response.getBody();

        System.out.println("Response: " + products);

        // Step 4: Validate the Response
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(2);
      
    }
}
