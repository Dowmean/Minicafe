//subject (แจ้งเตือนลูกค้า)
package com.example.minicafe.model.order;

import java.util.ArrayList;
import java.util.List;

public class OrderNotifier {
    private List<CustomerObserver> observers = new ArrayList<>();

    public void register(CustomerObserver obs) {
        observers.add(obs);
    }

    public void notifyAllObservers(String msg) {
        for (CustomerObserver obs : observers) {
            obs.notify(msg);
        }
    }
}