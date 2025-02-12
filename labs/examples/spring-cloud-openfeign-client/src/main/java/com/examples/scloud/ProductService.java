package com.examples.scloud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("scloud-product-service")
public interface ProductService {

    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct();

}
