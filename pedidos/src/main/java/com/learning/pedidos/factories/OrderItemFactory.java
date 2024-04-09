package com.learning.pedidos.factories;

import java.util.Scanner;

import com.learning.pedidos.entities.OrderItem;
import com.learning.pedidos.entities.Product;
import com.learning.pedidos.factories.interfaces.Factory;

public class OrderItemFactory implements Factory<OrderItem> {
    private final Scanner sc;
    private final Factory<Product> productFactory;

    public OrderItemFactory(Scanner sc) {
        this.sc = sc;
        this.productFactory = new ProductFactory(sc);
    }

    public OrderItem create() {
        Product product = productFactory.create();

        System.out.print("  Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        return new OrderItem(quantity, product);
    }
}
