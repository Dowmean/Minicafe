package com.example.minicafe.controller;

import com.example.minicafe.model.order.Order;
import com.example.minicafe.service.OrderService;
import com.example.minicafe.service.strategy.DailySalesStrategy;
import com.example.minicafe.service.strategy.WeeklySalesStrategy;
import com.example.minicafe.service.strategy.MonthlySalesStrategy;
import com.example.minicafe.service.strategy.SalesReport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {
    private final OrderService orderService;

    public DashboardController(OrderService orderService) {
        this.orderService = orderService;
    }

@GetMapping("/dashboard")
public String dashboard(Model model) {
    List<Order> orders = orderService.getOrders();

    SalesReport dailyReport = new DailySalesStrategy().calculateReport(orders);
    SalesReport weeklyReport = new WeeklySalesStrategy().calculateReport(orders);
    SalesReport monthlyReport = new MonthlySalesStrategy().calculateReport(orders);

    model.addAttribute("dailyReport", dailyReport);
    model.addAttribute("weeklyReport", weeklyReport);
    model.addAttribute("monthlyReport", monthlyReport);

    return "dashboard";
}

}
