package com.labs.orderapp.dao;

import com.labs.orderapp.model.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Slf4j
//@Repository
//@Primary
@NoArgsConstructor
@AllArgsConstructor
public class OrderDaoJdbcTempImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createOrder(Order order) {

        String sql = "INSERT INTO orders (description, category, quantity, price) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, order.getDescription(), order.getCategory(), order.getQuantity(), order.getPrice());
    }

    @Override
    public Collection<Order> getAllOrders() {

        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, OrderDaoJdbcTempImpl::getOrder);
    }

    public static Order getOrder(ResultSet rs, int rowNum) throws SQLException {
        log.info("Procecessing row: {}", rowNum);
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setDescription(rs.getString("description"));
        order.setCategory(rs.getString("category"));
        order.setQuantity(rs.getInt("quantity"));
        order.setPrice(rs.getDouble("price"));
        return order;
    }

    @Override
    public Order getOrder(int id) {
        return null;
    }

    @Override
    public boolean updateOrder(int id, Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(int id) {
        return false;
    }
}
