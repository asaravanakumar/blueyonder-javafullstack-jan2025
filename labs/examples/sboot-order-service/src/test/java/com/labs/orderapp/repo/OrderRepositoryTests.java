package com.labs.orderapp.repo;

import com.labs.orderapp.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCollection;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Map;

@Slf4j
@DataJpaTest
public class OrderRepositoryTests {
    // write tests here...
    // generate test cases
    // use Mockito or Spring Boot's testing utilities

//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Test
//    void testSave() {
//        // arrange
//        // create a new Order object
//        // act
//        // save the Order object
//        // assert
//        // check if the Order object is saved successfully
//        // and retrieved correctly
//        Order order = new Order();
//        order.setDescription("Test Order");
//        order.setCategory("Electronics");
//        order.setQuantity(1);
//        order.setPrice(199.99);
//
//
//        Order savedOrder = orderRepository.save(order);
//        Order retrievedOrder = orderRepository.findById(order.getId()).orElse(null);
//        assertNotNull(retrievedOrder);
//    }

    @Autowired
    private OrderRepository orderRepo;

    @BeforeEach
    void setUp() {
        Order order1 = Order.builder().description("Lenovo ThinkPad").category("Laptops").quantity(10).price(75000.0).build();
        Order order2 = Order.builder().description("HP Pavilion").category("Laptops").quantity(5).price(50000.0).build();
        Order order3 = Order.builder().description("Apple iPhone15").category("SmartPhones").quantity(10).price(70000.0).build();

        orderRepo.save(order1);
        orderRepo.save(order2);
        orderRepo.save(order3);
    }

    @AfterEach
    void tearDown() {
        orderRepo.deleteAll();
    }

    // given_when_then

    // givenValidCategoryWhenFindByCategoryThenReturnCategoryCount
    // givenInvalidCategoryWhenFindByCategoryThenThrowException

    @Test
    void givenValidCategoryWhenFindByCategoryThenReturnCategoryCount() {
        // given - provided

        // when - execution
        // then - checking

        // when
        List<Order> orders = orderRepo.findByCategory("Laptops");

        // then
        assertThat(orders.size()).isEqualTo(2);
    }

    @Test
    void findByCategoryAndQuantity() {

    }

    @Test
    void getCategoryWiseCount() {

        List<Map<String, Integer>> categoryCountList = orderRepo.getCategoryWiseCount();

        assertNotNull(categoryCountList);

//        log.info("Test: {}", categoryCountList.get(0).values());
//
//        assertThat(categoryCountList.size()).isEqualTo(2);
//
//        log.info("Test: {}", categoryCountList.get(0));
//
//        assertThatCollection(categoryCountList.get(0).values()).size().isEqualTo(2);
    }
}
