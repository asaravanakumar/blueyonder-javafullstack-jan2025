package com.labs.orderapp.dao;

import com.labs.orderapp.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;

@Slf4j
@Transactional
public class OrderDaoJpaImpl implements OrderDao {

//    @Autowired
//    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    private EntityManager em;

    @Override
    public int createOrder(Order order) {
        log.info("EntityManager created: {}", em);

//        EntityManager em = entityManagerFactory.createEntityManager();
//        em.getTransaction().begin();
        em.persist(order);
//        em.getTransaction().commit();
        log.info("Order created successfully: {}", order);
        return order.getId();
    }

    @Override
    public Collection<Order> getAllOrders() {
        log.info("Fetching all orders from database...");
//        EntityManager em = entityManagerFactory.createEntityManager();
        List<Order> orders = em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
        log.info("Fetched {} orders", orders.size());
        return orders;
    }

    @Override
    public Order getOrder(int id) {
        log.info("Fetching order with id {} from database...", id);
        return em.find(Order.class, id);
    }

    @Override
    public boolean updateOrder(int id, Order order) {
        Order existingOrder = em.find(Order.class, id);

        if (existingOrder == null) {
            throw new IllegalArgumentException("Order not found with id: " + id);
        }

        log.info("Updating order {} with new details: {}", existingOrder, order);
        return em.merge(order) != null; // merge the changes to the database

    }

    @Override
    public boolean deleteOrder(int id) {
        Order existingOrder = em.find(Order.class, id);

        if (existingOrder == null) {
            throw new IllegalArgumentException("Order not found with id: " + id);
        }

        log.info("Deleting order {}", existingOrder);
        em.remove(existingOrder);
        return true;

    }
}
