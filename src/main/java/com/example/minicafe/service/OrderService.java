// เก็บ list ของ order + logic
package com.example.minicafe.service;

import com.example.minicafe.model.order.Order;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrderById(int id) {
        return orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
