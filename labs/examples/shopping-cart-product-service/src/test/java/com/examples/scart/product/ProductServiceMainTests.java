package com.examples.scart.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class ProductServiceMainTests {

	@Autowired
	ApplicationContext ctx;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testApplicationContext() {
		System.out.println("Context: " + ctx);
		System.out.println(ctx.getBeanDefinitionCount());
		Assertions.assertThat(ctx).isNotNull();
	}
	
}
