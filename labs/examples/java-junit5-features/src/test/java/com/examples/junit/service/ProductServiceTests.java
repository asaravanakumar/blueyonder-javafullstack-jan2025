package com.examples.junit.service;

import com.examples.junit.ProductService;
import org.junit.jupiter.api.*;

import com.examples.junit.model.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTests {
	ProductService productService = new ProductService();

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

	@BeforeEach
	public void setup() {
		System.out.println("Test data initialization at each test case level..");
		// Initialize Test data
		Product mobile = new Product();
		mobile.setId("1");
		mobile.setName("Samsung Galaxy Note10");
		mobile.setCategory("Mobiles");
		mobile.setManufacturer("Samsung");
		productService.createProduct(mobile);

		Product laptop = new Product();
		laptop.setId("2");
		laptop.setName("Lenovo Thinkpad E490");
		laptop.setCategory("Laptops");
		laptop.setManufacturer("Samsung");
		productService.createProduct(laptop);
	}

	@AfterEach
	public void cleanup() {
		System.out.println("Test data clean up at each test case level..");
		productService.clear();
	}

	@Test
	public void shouldCreateProductWhenPassingMandatoryDetails() {
		Product product = new Product();
		product.setId("3");
		product.setName("Laptop");
		productService.createProduct(product);

		assertNotNull(productService.getProduct("3"));
		assertEquals("3", productService.getProduct("3").getId());
	}

    @Test
    public void shouldShowErrorWhenNotPassingMandatoryDetails() {
        Product product = new Product();
//        try {
//            productService.createProduct(product);
//        }
//        catch(Exception e) {
//            assertEquals("Product Id mandatory", e.getMessage());
//        }
		Throwable exception = assertThrows(Exception.class, () -> productService.createProduct(product));
		assertEquals("Product Id mandatory", exception.getMessage());
    }

    @Test
    public void shouldUpdateProductForGivenProductId() {
        Product laptop = new Product();
        laptop.setName("Lenovo Thinkpad E490");
        laptop.setCategory("Laptops");
        laptop.setManufacturer("Lenovo");

        productService.updateProduct("2", laptop);

        assertNotNull(productService.getProduct("2"));
        assertEquals("Lenovo",productService.getProduct("2").getManufacturer());
    }

    @Test
    public void shouldDeleteProductWhenPassingValidProductId() {
        productService.deleteProduct("2");
        assertNull(productService.getProduct("2"));
        assertEquals(1, productService.getProducts().size());
    }

    @Test
    public void shouldReturnProductForGivenProductId() {
        assertNotNull(productService.getProduct("2"));
        assertEquals("2",productService.getProduct("2").getId());
    }

    @Test
    public void shouldReturnAllProductsWhenDontSpecifyProductId() {
          assertEquals(2, productService.getProducts().size());
    }
}