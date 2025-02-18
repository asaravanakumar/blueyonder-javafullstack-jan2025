package com.labs.orderapp.service;

import com.labs.orderapp.model.Order;
import com.labs.orderapp.repo.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderServiceJpaRepoImplTests {

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepo;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void givenValidOrderDetailsWhenCreateOrderThenReturnOrderId() {
        // given
        Order order1 = Order.builder().description("Lenovo ThinkPad").category("Laptops").quantity(10).price(75000.0).build();

        order1.setId(100);
        Mockito.when(orderRepo.save(Mockito.any())).thenReturn(order1);

        //when
        int id = orderService.createOrder(order1);

        //then
        assertThat(id).isNotNegative();
        assertThat(id).isEqualTo(100);
    }
}
