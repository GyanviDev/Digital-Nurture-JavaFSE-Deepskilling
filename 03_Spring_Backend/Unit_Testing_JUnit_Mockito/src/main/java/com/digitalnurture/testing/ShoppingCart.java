package com.digitalnurture.testing;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> items;
    private double totalPrice;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addItem(String item, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        items.add(item);
        totalPrice += price;
    }

    public int getItemCount() {
        return items.size();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void emptyCart() {
        items.clear();
        totalPrice = 0.0;
    }
}