package factories;

import java.util.Scanner;

import entities.*;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ProductFactory {

    private ProductFactory() {}

    public static Product createProduct(char type, Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        Double price = sc.nextDouble();

        if (type == 'i') {
            System.out.print("Customs fee: ");
            Double customsFee = sc.nextDouble();
            return new ImportedProduct(name, price, customsFee);
        } else if (type == 'u') {
            System.out.print("Manufacture date (DD/MM/YYYY): ");
            sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date manufactureDate = sdf.parse(sc.nextLine());
                return new UsedProduct(name, price, manufactureDate);
            } catch (Exception e) {
                System.out.println("Invalid date format. Using current date instead.");
                return new UsedProduct(name, price, new Date());
            }
        } else if (type == 'c') {
            return new Product(name, price);
        } else {
            throw new IllegalArgumentException("Invalid product type.");
        }
    }
}
