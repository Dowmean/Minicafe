package com.example.minicafe.model.observer;

import com.example.minicafe.model.order.Order;

public class PendingState implements OrderState {
    public String getStatus() {
        return "รอคิว";
    }
    public void next(Order order) {
        order.setState(new InProgressState());
    }
}
