package com.example.minicafe.service.strategy;

import com.example.minicafe.model.order.Order;
import java.util.List;

public interface SalesStrategy {
    SalesReport calculateReport(List<Order> orders);
}
