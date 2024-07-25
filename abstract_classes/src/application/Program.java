package application;

import entities.Person;
import factories.PersonFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of tax payers: ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.println("Tax payer #" + i + " data:");
                System.out.print("Individual or company (i/c)? ");
                char type = sc.next().charAt(0);
                sc.nextLine();
                list.add(PersonFactory.createPerson(type, sc));
            }

            System.out.println();
            System.out.println("TAXES PAID:");
            double totalTaxes = 0.0;
            for (Person person : list) {
                System.out.println(person.getName() + ": $ " + String.format("%.2f", person.tax()));
                totalTaxes += person.tax();
            }

            System.out.println();
            System.out.println("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));
        }
    }
}
