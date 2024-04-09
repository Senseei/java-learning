package com.learning.pedidos.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.learning.pedidos.entities.enums.OrderStatus;

public class Order {
    private List<OrderItem> items = new ArrayList<>();
    private OrderStatus status;
    private Client client;
    private Date moment;

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
        this.moment = new Date();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public Date getMoment() {
        return moment;
    }

    public double total() {
        double sum = 0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:\n");
        sb.append("Order moment: ");
        sb.append(moment + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");

        for (OrderItem item : items)
            sb.append(item + "\n");

        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
