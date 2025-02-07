package com.labs.orderapp.config;

import com.labs.orderapp.dao.OrderDao;
import com.labs.orderapp.dao.OrderDaoJdbcImpl;
import com.labs.orderapp.dao.OrderDaoJdbcTempImpl;
import com.labs.orderapp.dao.OrderDaoJpaImpl;
import com.labs.orderapp.service.OrderService;
import com.labs.orderapp.service.OrderServiceJdbcImpl;
import com.labs.orderapp.service.OrderServiceJpaRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class OrderConfig {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Bean
    public OrderService orderService() {
//        return new OrderServiceJdbcImpl(orderDao());
        return new OrderServiceJpaRepoImpl();
    }

//orderDao    @Bean
//    public OrderDao orderDao() {
////        return new OrderDaoJdbcTempImpl();}
//        return new OrderDaoJpaImpl();
//    }
}
