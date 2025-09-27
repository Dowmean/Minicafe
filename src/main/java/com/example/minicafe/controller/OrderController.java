package com.example.minicafe.controller;

import com.example.minicafe.model.coffee.*;
import com.example.minicafe.model.observer.CompletedState;
import com.example.minicafe.model.observer.InProgressState;
import com.example.minicafe.model.observer.PendingState;
import com.example.minicafe.model.order.*;
import com.example.minicafe.service.OrderService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("menuRecipes", CoffeeFactory.getAllRecipes());
        return "index"; // หน้าเลือกเมนู
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderService.getOrders());
        return "orders";
    }

    @PostMapping("/orders/{id}/next")
    public String nextState(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            order.nextState();
        }
        return "redirect:/orders";
    }

    @PostMapping("/orders/{id}/update")
    public String updateStatus(@PathVariable int id, @RequestParam String status) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            switch (status) {
                case "Pending":
                    order.setState(new PendingState());
                    break;
                case "InProgress":
                    order.setState(new InProgressState());
                    break;
                case "Completed":
                    order.setState(new CompletedState());
                    break;
            }
        }
        return "redirect:/orders";
    }

    // ตอนกดสั่ง จะสร้าง order แล้วส่ง id ไป cart
    @PostMapping("/cart")
    public String cart(@RequestParam String flavor,
            @RequestParam String option,
            @RequestParam String sweetness) {
        CoffeeRecipe recipe = CoffeeFactory.getRecipe(flavor);
        Order order = new Order();
        order.addItem(recipe, option, sweetness);
        orderService.addOrder(order);

        // ไปหน้า cart รวมทุกออเดอร์
        return "redirect:/cart";
    }

    @GetMapping("/cart/{id}")
    public String viewCart(@PathVariable int id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<Order> orders = orderService.getOrders();

        // เรียง order ใหม่สุดไว้บนสุด (id มาก → บน)
        orders.sort((o1, o2) -> Integer.compare(o2.getId(), o1.getId()));

        model.addAttribute("orders", orders);
        return "cart";
    }

    @GetMapping("/track")
    public String track(@RequestParam int id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "track";
    }

}