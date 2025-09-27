package com.example.minicafe.model.coffee;

import java.util.HashMap;
import java.util.Map;

public class CoffeeFactory {
    private static Map<String, CoffeeRecipe> recipes = new HashMap<>();

    public static CoffeeRecipe getRecipe(String flavor) {
        if (!recipes.containsKey(flavor)) {
            int price = switch (flavor.toLowerCase()) {
                case "latte" -> 40;
                case "mocha" -> 45;
                case "tea" -> 30;
                case "espresso" -> 35;
                case "americano" -> 35;
                case "cappuccino" -> 40;
                case "matcha" -> 45;
                case "thai tea" -> 35;
                case "milk tea" -> 35;
                case "black coffee" -> 30;
                case "green tea" -> 35;
                case "chocolate" -> 40;
                case "caramel macchiato" -> 50;
                case "hazelnut latte" -> 50;
                case "vanilla latte" -> 50;
                case "coconut coffee" -> 45;
                case "honey lemon" -> 35;
                case "milk" -> 25;
                case "yuzu americano" -> 55;
                case "strawberry smoothie" -> 60;
                default -> 35;
            };
            recipes.put(flavor, new CoffeeRecipe(flavor, price));
        }
        return recipes.get(flavor);
    }

    // ✅ ใช้สำหรับแสดงเมนูทั้งหมด
    public static Map<String, CoffeeRecipe> getAllRecipes() {
        // บังคับสร้างเมนู 20 รายการ
        getRecipe("Latte");
        getRecipe("Mocha");
        getRecipe("Tea");
        getRecipe("Espresso");
        getRecipe("Americano");
        getRecipe("Cappuccino");
        getRecipe("Matcha");
        getRecipe("Thai Tea");
        getRecipe("Milk Tea");
        getRecipe("Black Coffee");
        getRecipe("Green Tea");
        getRecipe("Chocolate");
        getRecipe("Caramel Macchiato");
        getRecipe("Hazelnut Latte");
        getRecipe("Vanilla Latte");
        getRecipe("Coconut Coffee");
        getRecipe("Honey Lemon");
        getRecipe("Milk");
        getRecipe("Yuzu Americano");
        getRecipe("Strawberry Smoothie");

        return recipes;
    }
}
