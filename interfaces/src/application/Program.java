package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import services.ContractService;
import services.PayPalService;
import entities.Contract;

public class Program {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            ContractService contractService = new ContractService(new PayPalService());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.println("Enter contract data:");

            System.out.print("Number: ");
            Integer number = scanner.nextInt();

            System.out.print("Date (dd/MM/yyyy): ");
            String dateString = scanner.next();
            LocalDate date = LocalDate.parse(dateString, formatter);

            System.out.print("Total value: ");
            Double totalValue = scanner.nextDouble();

            Contract contract = new Contract(number, date, totalValue);

            System.out.print("Enter number of installments: ");
            int months = scanner.nextInt();
    
            contractService.processContract(contract, months);

            contract.printInstallments();
        }
    }
}
