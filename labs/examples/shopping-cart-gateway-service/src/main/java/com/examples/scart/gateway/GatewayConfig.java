package com.examples.scart.gateway;

//import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.RouterFunctions;
//import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayConfig {

//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("example", r -> r.path("/example/**")
//                        .uri("http://localhost:8081")) // Forward requests to another service
//                .build();
//    }

//    @Bean
//    public RouterFunction<ServerResponse> getRoute() {
//        return RouterFunctions.route().GET("/get", HandlerFunctions.http("https://httpbin.org")).build();
//    }

//    @Bean
//    public RouterFunction<ServerResponse> getProductsRoute() {
//        return RouterFunctions.route().GET("/products", HandlerFunctions.http("http://localhost:9090")).build();
//    }
}