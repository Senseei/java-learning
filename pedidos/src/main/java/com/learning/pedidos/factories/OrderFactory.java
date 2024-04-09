package com.learning.pedidos.factories;

import java.util.Scanner;

import com.learning.pedidos.factories.interfaces.Factory;
import com.learning.pedidos.entities.Client;
import com.learning.pedidos.entities.Order;
import com.learning.pedidos.entities.OrderItem;
import com.learning.pedidos.entities.enums.OrderStatus;

public class OrderFactory implements Factory<Order> {
    private final Scanner sc;
    private final Factory<Client> clientFactory;
    private final Factory<OrderItem> orderItemFactory;

    public OrderFactory(Scanner sc) {
        this.sc = sc;
        this.clientFactory = new ClientFactory(sc);
        this.orderItemFactory = new OrderItemFactory(sc);
    }

    public Order create() {
        Client client = clientFactory.create();

        System.out.println("Enter order data:");
        System.out.print("  Status: ");
        String status = sc.nextLine();
        Order order = new Order(OrderStatus.valueOf(status), client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("  Enter #" + i + " item data:");
            OrderItem item = orderItemFactory.create();
            order.addItem(item);
        }

        return order;
    }
}
