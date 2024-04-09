package com.learning.pedidos.factories;

import java.util.Scanner;

import com.learning.pedidos.factories.interfaces.Factory;
import com.learning.pedidos.entities.Client;

public class ClientFactory implements Factory<Client> {
    private final Scanner sc;

    public ClientFactory(Scanner sc) {
        this.sc = sc;
    }

    public Client create() {
        System.out.println("Enter client data:");
        System.out.print("  Name: ");
        String name = sc.nextLine();
        System.out.print("  Email: ");
        String email = sc.nextLine();
        System.out.print("  Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();

        return new Client(name, email, birthDate);
    }
}
