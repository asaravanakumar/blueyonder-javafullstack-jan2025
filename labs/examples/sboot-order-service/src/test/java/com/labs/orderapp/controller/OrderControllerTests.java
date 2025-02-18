package com.labs.orderapp.controller;

import com.labs.orderapp.model.Order;
import com.labs.orderapp.service.OrderService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasEntry;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTests {

    @LocalServerPort
    private int port;

    @MockBean
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void givenValidOrder_WhenCreateOrder_ThenReturnSuccessMsg() {

        Order order1 = Order.builder().description("Lenovo ThinkPad").category("Laptops").quantity(10).price(75000.0).build();

        Mockito.when(orderService.createOrder(Mockito.any())).thenReturn(100);

        given()
                .body(order1)
                .contentType(ContentType.JSON)
                .when()
                .post("/orders")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body(equalTo("{\"status\":\"SUCCESS\",\"message\":\"Order created successfully\"}"));
    }

    @Test
    void whenGetAllOrders_ThenReturnOrderList() {
        Order order1 = Order.builder().description("Lenovo ThinkPad").category("Laptops").quantity(10).price(75000.0).build();

        Mockito.when(orderService.getAllOrders()).thenReturn(List.of(order1));

//        Response response = given().when().get("/orders");
//
//        List<Order> orderList = response.jsonPath().getList("");
//
//        Assertions.assertThat(orderList.size()).isEqualTo(1);

        given()
                .when()
                .get("/orders")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("$", hasSize(1))
                .body("$", contains(
                        hasEntry("category", "Laptops")
                ));
    }

}
