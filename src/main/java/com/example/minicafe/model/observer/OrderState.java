//State interface
package com.example.minicafe.model.observer;

import com.example.minicafe.model.order.Order;

public interface OrderState {
    String getStatus();
    void next(Order order);
}