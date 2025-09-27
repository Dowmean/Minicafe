package com.example.minicafe.service.strategy;

import com.example.minicafe.model.order.Order;
import java.time.LocalDate;
import java.util.List;

public class DailySalesStrategy implements SalesStrategy {
    @Override
    public SalesReport calculateReport(List<Order> orders) {
        LocalDate today = LocalDate.now();

        int total = orders.stream()
                .filter(o -> o.getOrderedAt().toLocalDate().isEqual(today))
                .mapToInt(Order::getTotal)
                .sum();

        // รายวัน startDate = endDate = วันนี้
        return new SalesReport(total, today, today);
    }
}

