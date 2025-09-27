package com.example.minicafe.model.order;

import com.example.minicafe.model.coffee.CoffeeRecipe;
import com.example.minicafe.model.observer.OrderState;
import com.example.minicafe.model.observer.PendingState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;
    private int id;
    private List<OrderItem> items = new ArrayList<>(); // ✅ เก็บเป็น object
    private OrderState state;
    private int total = 0; // ✅ เก็บราคารวม

    // ✅ เวลาออเดอร์ถูกสร้าง
    private LocalDateTime orderedAt;

    public Order() {
        this.id = counter++;
        this.state = new PendingState();
        this.orderedAt = LocalDateTime.now(); // กำหนดเวลาที่สร้าง order
    }

    public int getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    // ✅ รองรับ option + sweetness + price
    public void addItem(CoffeeRecipe recipe, String option, String sweetness) {
        int price = recipe.getPrice();
        if ("เย็น".equals(option)) {
            price += 5; // เย็นแพงกว่าร้อน 5 บาท
        }

        OrderItem item = new OrderItem(recipe.getFlavor(), option, sweetness, price);
        items.add(item);
        total += price;
    }

    public String getStatus() {
        return state.getStatus();
    }

    public void nextState() {
        state.next(this);
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    // ✅ getter ราคารวม
    public int getTotal() {
        return total;
    }

    // ✅ getter เวลาออเดอร์
    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }
}
