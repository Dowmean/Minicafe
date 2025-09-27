package com.example.minicafe.model.observer;

import com.example.minicafe.model.order.Order;

public class CompletedState implements OrderState {
    public String getStatus() {
        return "เสร็จแล้ว";
    }
    public void next(Order order) {
        System.out.println("Order เสร็จสิ้นแล้ว");
    }
}