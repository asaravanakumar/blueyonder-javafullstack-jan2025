package com.examples.scloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

@Slf4j
@EnableFeignClients
@SpringBootApplication
public class ScloudOpenfeignClientApplication implements CommandLineRunner {

//	private Logger log = LoggerFactory.getLogger(ScloudOpenfeignClientApplication.class);

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ScloudOpenfeignClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=0; i < 4; i++) {
			ResponseEntity<Object> response = productService.getProduct();
			log.info(response.getBody().toString());
		}
	}
}
