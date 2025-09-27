package com.example.minicafe.service.strategy;

import com.example.minicafe.model.order.Order;
import java.time.LocalDate;
import java.util.List;

public class WeeklySalesStrategy implements SalesStrategy {
    @Override
    public SalesReport calculateReport(List<Order> orders) {
        LocalDate today = LocalDate.now();
        LocalDate weekAgo = today.minusDays(6); // รวมวันนี้ด้วย = 7 วัน

        int total = orders.stream()
                .filter(o -> {
                    LocalDate date = o.getOrderedAt().toLocalDate();
                    return !date.isBefore(weekAgo) && !date.isAfter(today);
                })
                .mapToInt(Order::getTotal)
                .sum();

        return new SalesReport(total, weekAgo, today);
    }
}
