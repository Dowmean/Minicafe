//observer (ลูกค้า)
package com.example.minicafe.model.order;

public class CustomerObserver {
    private String name;

    public CustomerObserver(String name) {
        this.name = name;
    }

    public void notify(String msg) {
        System.out.println(name + " ได้รับแจ้ง: " + msg);
    }
}