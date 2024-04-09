package com.learning.pedidos;

import java.util.Scanner;

import com.learning.pedidos.entities.Order;
import com.learning.pedidos.factories.OrderFactory;
import com.learning.pedidos.factories.interfaces.Factory;

public class Pedidos {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Factory<Order> orderFactory = new OrderFactory(sc);
            
            Order order = orderFactory.create();
            System.out.println(order);
        }
    }
}
