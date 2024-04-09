package com.learning.pedidos.entities;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + ", $" + String.format("%.2f", price);
    }
}
