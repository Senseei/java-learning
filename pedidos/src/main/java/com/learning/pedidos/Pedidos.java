package com.learning.pedidos;

import java.util.Scanner;

import com.learning.pedidos.entities.Client;
import com.learning.pedidos.entities.Order;
import com.learning.pedidos.entities.OrderItem;
import com.learning.pedidos.entities.Product;
import com.learning.pedidos.entities.enums.OrderStatus;

public class Pedidos {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter client data:");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Birth date (DD/MM/YYYY): ");
            String birthDate = sc.nextLine();

            Client client = new Client(name, email, birthDate);

            System.out.println("Enter order data:");
            System.out.print("Status: ");
            String status = sc.nextLine();
            Order order = new Order(OrderStatus.valueOf(status), client);

            System.out.print("How many items to this order? ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.println("Enter #" + i + " item data:");
                System.out.print("Product name: ");
                sc.nextLine();
                String productName = sc.nextLine();
                System.out.print("Product price: ");
                double productPrice = sc.nextDouble();
                Product product = new Product(productName, productPrice);

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                OrderItem item = new OrderItem(quantity, product);
                order.addItem(item);
            }

            System.out.println(order);
        }
    }
}
