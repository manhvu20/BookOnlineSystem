package com.bookonline.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import com.bookonline.entities.Orders;

@Stateless
public class OrdersManagement {

    @PersistenceContext
    private EntityManager entityManager;

    public void createOrder(Orders order) {
        entityManager.persist(order);
    }

    public List<Orders> getAllOrders() {
        return entityManager.createQuery("SELECT o FROM Orders o", Orders.class).getResultList();
    }

    public void updateOrder(Orders order) {
        entityManager.merge(order);
    }

    public void deleteOrder(Long orderId) {
        Orders order = entityManager.find(Orders.class, orderId);
        if (order != null) {
            entityManager.remove(order);
        }
    }
}
