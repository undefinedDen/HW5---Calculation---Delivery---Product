package app.view;

import app.entity.Product;
import java.util.Scanner;

public class AppView {
    Scanner scanner = new Scanner(System.in);

    public void getDisplayInfo(String output) {
        System.out.print(output);
    }

    public void getDisplayInfo(Product output) {
        System.out.print(output);
    }

    public void getMenu() {
        System.out.println("""
                \nMenu:
                1 - show all products
                2 - calculation cost product with delivery
                3 - exit
                """);
    }

    public double getDistanceToClient() {
        System.out.print("Input distance from courier to client in kilometers: ");
        return scanner.nextDouble();

    }

    public int getInputNum(String output) {
        System.out.print(output);
        return scanner.nextInt();
    }

    public String getInputName(String output) {
        System.out.print(output);
        return scanner.nextLine();
    }

    public void getLine() {
        scanner.nextLine();
    }
}
