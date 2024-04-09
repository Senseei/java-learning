package com.learning.pedidos.entities;

public class OrderItem {
    private int quantity;
    private Product product;

    public OrderItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double subTotal() {
        return product.getPrice() * quantity;
    }

    public String toString() {
        return product + ", Quantity: " + quantity + ", Subtotal: $" + String.format("%.2f", subTotal());
    }
}
