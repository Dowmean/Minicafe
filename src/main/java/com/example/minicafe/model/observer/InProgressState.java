package com.example.minicafe.model.observer;

import com.example.minicafe.model.order.Order;

public class InProgressState implements OrderState {
    public String getStatus() {
        return "กำลังทำ";
    }
    public void next(Order order) {
        order.setState(new CompletedState());
    }
}