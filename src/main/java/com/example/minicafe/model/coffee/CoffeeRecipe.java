//# Flyweight object
package com.example.minicafe.model.coffee;

public class CoffeeRecipe {
    private String flavor;
    private int price; // ราคา

    public CoffeeRecipe(String flavor, int price) {
        this.flavor = flavor;
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return flavor + " (" + price + " บาท)";
    }
}
