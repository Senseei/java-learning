package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;
import factories.ProductFactory;

public class Program {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of products: ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.println("Product #" + i + " data:");
                System.out.print("Common, used or imported (c/u/i)? ");
                char type = sc.next().charAt(0);

                sc.nextLine();

                Product product = ProductFactory.createProduct(type, sc);
                products.add(product);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }
    }
}
