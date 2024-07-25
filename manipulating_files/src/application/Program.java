package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        String path = "c:\\temp\\in.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                Product product = new Product(fields[0], Double.parseDouble(fields[1]), Integer.parseInt(fields[2]));
                list.add(product);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        String outPath = "c:\\temp\\out.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {
            for (Product product : list) {
                bw.write(product.getName() + "," + String.format("%.2f", product.total()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
