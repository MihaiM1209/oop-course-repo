package oop.practice.lab2.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barista {
    private List<Coffee> coffeeMenu;

    public Barista() {
        coffeeMenu = new ArrayList<>();
        // You could pre-load some default coffee options here if desired
    }

    // Method to show menu and take orders
    public void showMenuAndTakeOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean ordering = true;

        while (ordering) {
            System.out.println("Welcome to the Coffee Shop! Please choose an option:");
            System.out.println("1. Americano");
            System.out.println("2. Cappuccino");
            System.out.println("3. Pumpkin Spice Latte");
            System.out.println("4. Syrup Cappuccino");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAmericano(scanner);
                    break;
                case 2:
                    createCappuccino(scanner);
                    break;
                case 3:
                    createPumpkinSpiceLatte(scanner);
                    break;
                case 4:
                    createSyrupCappuccino(scanner);
                    break;
                case 5:
                    ordering = false;
                    System.out.println("Thank you for visiting!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
            System.out.println();
        }

        scanner.close();
    }

    // Method to create an Americano
    private void createAmericano(Scanner scanner) {
        System.out.print("Enter intensity (1 for LIGHT, 2 for NORMAL, 3 for STRONG): ");
        Intensity intensity = getIntensityFromUser(scanner);

        System.out.print("Enter amount of water in ml: ");
        int mlOfWater = scanner.nextInt();

        Americano americano = new Americano(intensity, mlOfWater);
        americano.printCoffeeDetails();
    }

    // Method to create a Cappuccino
    private void createCappuccino(Scanner scanner) {
        System.out.print("Enter intensity (1 for LIGHT, 2 for NORMAL, 3 for STRONG): ");
        Intensity intensity = getIntensityFromUser(scanner);

        System.out.print("Enter amount of milk in ml: ");
        int mlOfMilk = scanner.nextInt();

        Cappuccino cappuccino = new Cappuccino(intensity, mlOfMilk);
        cappuccino.printCoffeeDetails();
    }

    // Method to create a Pumpkin Spice Latte
    private void createPumpkinSpiceLatte(Scanner scanner) {
        System.out.print("Enter intensity (1 for LIGHT, 2 for NORMAL, 3 for STRONG): ");
        Intensity intensity = getIntensityFromUser(scanner);

        System.out.print("Enter amount of milk in ml: ");
        int mlOfMilk = scanner.nextInt();

        System.out.print("Enter amount of pumpkin spice in mg: ");
        int mgOfPumpkinSpice = scanner.nextInt();

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        pumpkinSpiceLatte.printCoffeeDetails();
    }

    // Method to create a Syrup Cappuccino
    private void createSyrupCappuccino(Scanner scanner) {
        System.out.print("Enter intensity (1 for LIGHT, 2 for NORMAL, 3 for STRONG): ");
        Intensity intensity = getIntensityFromUser(scanner);

        System.out.print("Enter amount of milk in ml: ");
        int mlOfMilk = scanner.nextInt();

        System.out.println("Choose syrup type:");
        for (int i = 0; i < SyrupType.values().length; i++) {
            System.out.println((i + 1) + ". " + SyrupType.values()[i]);
        }
        System.out.print("Enter syrup choice (1-" + SyrupType.values().length + "): ");
        int syrupChoice = scanner.nextInt();
        SyrupType syrup = SyrupType.values()[syrupChoice - 1];

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrup);
        syrupCappuccino.printCoffeeDetails();
    }

    // Helper method to get intensity from user input
    private Intensity getIntensityFromUser(Scanner scanner) {
        int intensityChoice = scanner.nextInt();
        switch (intensityChoice) {
            case 1: return Intensity.LIGHT;
            case 2: return Intensity.MEDIUM;
            case 3: return Intensity.STRONG;
            default:
                System.out.println("Invalid choice, defaulting to NORMAL intensity.");
                return Intensity.MEDIUM;
        }
    }
}
