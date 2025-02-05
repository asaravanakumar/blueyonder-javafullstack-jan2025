package com.examples.sboot.lombok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbootLombokDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootLombokDemoApplication.class, args);
		Product product = new Product();
		product.setId(100);
		product.setName("Lenovo ThinkPad");
		product.setCategory("Laptop");
		product.setManufacturer("Lenovo");
		product.setPrice(80000);

		Product product1 = new Product(101, "Dell Inspiron", "Laptop", "Dell", 75000);

		System.out.println(product);
		System.out.println(product1);
		System.out.println(product.getId() + " " + product.getName() + " " + product.getCategory() +
				" " + product.getManufacturer() + " " + product.getPrice());

	}

}
