package com.examples.scart.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.examples.scart.product.model.Product;
import com.examples.scart.product.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTests {

	@Autowired
	ProductService productService;

	@MockBean
	ProductRepository productRepo;

	@BeforeAll
	public static void init() {
		// Logic to initialize test data goes here
		System.out.println("Test data initialization at class level..");
	}

	@AfterAll
	public static void tearDown() {
		// Logic to clean up test data goes here
		System.out.println("Test data clean up at class level..");
	}
	
	private static List<Product> products = new ArrayList<>();

	@BeforeEach
	public void setup() {
		// Initialize Test data
		Product mobile = new Product();
		mobile.setId("1");
		mobile.setName("Samsung Galaxy Note10");
		mobile.setCategory("Mobiles");
		mobile.setManufacturer("Samsung");
//		productService.createProduct(mobile);
		products.add(mobile);

		Product laptop = new Product();
		laptop.setId("2");
		laptop.setName("Lenovo Thinkpad E490");
		laptop.setCategory("Laptops");
		laptop.setManufacturer("Lenovo");
//		productService.createProduct(laptop);
		products.add(laptop);
	}

	@AfterEach
	public void cleanup() {
//		productService.clear();
		products.clear();
	}

	@Test
	public void shouldCreateProductWhenPassingMandatoryDetails() {
		Product newProduct = new Product();
		newProduct.setId("3");
		newProduct.setName("Laptop");
		productService.createProduct(newProduct);

		Product savedProduct = new Product();
		savedProduct.setId("3");
		savedProduct.setName("Laptop");
		productService.createProduct(savedProduct);

		Mockito.lenient().when(productRepo.save(Mockito.any())).thenReturn(savedProduct);
		Mockito.lenient().when(productRepo.findById(Mockito.any())).thenReturn(Optional.of(savedProduct));

		productService.createProduct(newProduct);

		assertNotNull(productService.getProduct("3"));
		assertEquals("3", productService.getProduct("3").getId());
	}

	@Test
	public void shouldShowErrorWhenNotPassingMandatoryDetails() {
		Mockito.lenient().when(productRepo.save(Mockito.any())).thenThrow(new RuntimeException("Product Id Mandatory"));

		Product product = new Product();

		Exception e = assertThrows(RuntimeException.class, () -> productService.createProduct(product));

		assertEquals("Product Id mandatory", e.getMessage());
	}

	@Test
	public void shouldUpdateProductForGivenProductId() {

		Product laptop = new Product();
		laptop.setName("Lenovo Thinkpad E490");
		laptop.setCategory("Laptops");
		laptop.setManufacturer("Lenovo");

		Mockito.lenient().when(productRepo.save(Mockito.any())).thenReturn(laptop);
		Mockito.lenient().when(productRepo.findById("2")).thenReturn(Optional.of(laptop));

		productService.updateProduct("2", laptop);

		assertNotNull(productService.getProduct("2"));
		assertEquals("Lenovo", productService.getProduct("2").getManufacturer());
	}

	@Test
	public void shouldDeleteProductWhenPassingValidProductId() {

		Mockito.lenient().when(productRepo.findById("2")).thenReturn(Optional.ofNullable(null));


		productService.deleteProduct("2");
		assertNull(productService.getProduct("2"));
	}

	@Test
	public void shouldReturnProductForGivenProductId() {
		Mockito.when(productRepo.findById("2")).thenReturn(Optional.of(products.get(1)));
		
		
		assertNotNull(productService.getProduct("2"));
		assertEquals("2", productService.getProduct("2").getId());
	}

	@Test
	public void shouldReturnAllProductsWhenDontSpecifyProductId() {
		Mockito.when(productRepo.findAll()).thenReturn(products);
		
		assertEquals(2, productService.getProducts().size());
	}

}
