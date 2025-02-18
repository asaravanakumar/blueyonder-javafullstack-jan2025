package com.labs.orderapp.controller;

import com.labs.orderapp.model.Order;
import com.labs.orderapp.model.ResponseMessage;
import com.labs.orderapp.service.OrderService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
//    @Qualifier("orderServiceJdbcImpl")
    private OrderService orderService;

//    GET 		/orders
//    POST		/orders
//    GET		/orders/{id}
//    PUT		/orders/{id}
//    DELETE	/orders/{id}

    // http://localhost:8080/orders
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Collection<Order>> getAllOrders() {
//        Order order1 = new Order(100, "Lenovo ThinkPad", "Laptop", 1000, 50000.0);
//        Order order2 = new Order(101, "iPhone 12", "Mobile Phone", 10, 100000.0);
//        return List.of(order1, order2);
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }
// http://localhost:8080/orders/100
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable int id) {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ResponseMessage> createOrder(@RequestBody @Valid Order order) {
        log.info("Received order: {}", order);
        var id = 0;
//        try {
            id = orderService.createOrder(order);
//        }catch (IllegalArgumentException e) {
//            return ResponseEntity
//                   .badRequest()
//                   .body(ResponseMessage.builder().status("ERROR")
//                            .message(e.getMessage()).build());
//        }
//        return "Order created successfully";

        // Location: http://localhost:8080/orders/{id}
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + id).build().toUri();
        return ResponseEntity
                .created(location)
                .body(ResponseMessage.builder().status("SUCCESS")
                        .message("Order created successfully").build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateOrder(@PathVariable int id, @RequestBody @Valid Order updatedOrder) {
        Order existingOrder = orderService.getOrder(id);

        if (existingOrder == null) {
            return ResponseEntity
                    .badRequest()
                    .body(ResponseMessage.builder().status("ERROR")
                            .message("Order not found").build());
        }
        updatedOrder.setId(id);
        orderService.updateOrder(id, updatedOrder);

        return ResponseEntity
                .ok()
                .body(ResponseMessage.builder().status("SUCCESS")
                        .message("Order updated successfully").build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteOrder(@PathVariable int id) {
        Order existingOrder = orderService.getOrder(id);
        if (existingOrder == null) {
            return ResponseEntity
                    .badRequest()
                    .body(ResponseMessage.builder().status("ERROR")
                            .message("Order not found").build());
        }
        orderService.deleteOrder(id);
        return ResponseEntity
                .ok()
                .body(ResponseMessage.builder().status("SUCCESS")
                        .message("Order deleted successfully").build());
    }

//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ResponseMessage> handleValidationException(Exception e) {
//        return ResponseEntity
//               .badRequest()
//               .body(ResponseMessage.builder().status("ERROR")
//                        .message(e.getMessage()).build());
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseMessage> handleValidationException(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity
                .badRequest()
                .body(ResponseMessage.builder().status("ERROR")
                        .message(errorMsg).build());
    }

}