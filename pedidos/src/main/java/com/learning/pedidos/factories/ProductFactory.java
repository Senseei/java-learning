package com.learning.pedidos.factories;

import java.util.Scanner;

import com.learning.pedidos.entities.Product;
import com.learning.pedidos.factories.interfaces.Factory;

public class ProductFactory implements Factory<Product>{
    private final Scanner sc;

    public ProductFactory(Scanner sc) {
        this.sc = sc;
    }

    public Product create() {
        System.out.println("Enter product data:");
        System.out.print("  Name: ");
        String name = sc.nextLine();
        System.out.print("  Price: ");
        double price = sc.nextDouble();

        return new Product(name, price);
    }
}
