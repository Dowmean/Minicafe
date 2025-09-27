package com.example.minicafe.service.strategy;

import com.example.minicafe.model.order.Order;
import java.time.LocalDate;
import java.util.List;

public class MonthlySalesStrategy implements SalesStrategy {
    @Override
    public SalesReport calculateReport(List<Order> orders) {
        LocalDate today = LocalDate.now();
        LocalDate monthAgo = today.minusDays(29); // 30 วันย้อนหลัง

        int total = orders.stream()
                .filter(o -> {
                    LocalDate date = o.getOrderedAt().toLocalDate();
                    return !date.isBefore(monthAgo) && !date.isAfter(today);
                })
                .mapToInt(Order::getTotal)
                .sum();

        return new SalesReport(total, monthAgo, today);
    }
}

