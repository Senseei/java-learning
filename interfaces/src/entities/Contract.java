package entities;

import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;

public class Contract {

    private Integer number;
    private LocalDate date;
    private Double totalValue;
    private List<Installment> installments;

    public Contract(int number, LocalDate date, double totalValue) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be a positive integer.");
        }
        if (date == null || date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be null or in the future.");
        }
        if (totalValue <= 0) {
            throw new IllegalArgumentException("Total value must be a positive number.");
        }
    
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
        this.installments = new ArrayList<>();
    }

    public Integer getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void printInstallments() {
        System.out.println("Installments:");
        for (Installment installment : installments) {
            System.out.println(installment);
        }
    }
}
