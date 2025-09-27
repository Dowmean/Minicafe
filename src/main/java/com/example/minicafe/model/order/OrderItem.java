package com.example.minicafe.model.order;

public class OrderItem {
    private String flavor;
    private String option;
    private String sweetness;
    private int price;

    public OrderItem(String flavor, String option, String sweetness, int price) {
        this.flavor = flavor;
        this.option = option;
        this.sweetness = sweetness;
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getOption() {
        return option;
    }

    public String getSweetness() {
        return sweetness;
    }

    public int getPrice() {
        return price;
    }
}
