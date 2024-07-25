package factories;

import entities.Corporate;
import entities.Individual;
import entities.Person;
import java.util.Scanner;

public class PersonFactory {
    
    private PersonFactory() {}

    public static Person createPerson(char type, Scanner sc) {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Anual income: ");
        double anualIncome = sc.nextDouble();
        if (type == 'i') {
            System.out.print("Health expenditures: ");
            double healthExpenditures = sc.nextDouble();
            return new Individual(name, anualIncome, healthExpenditures);
        } else if (type == 'c') {
            System.out.print("Number of employees: ");
            int numberOfEmployees = sc.nextInt();
            return new Corporate(name, anualIncome, numberOfEmployees);
        }
        throw new IllegalArgumentException("Invalid person type.");
    }
}
