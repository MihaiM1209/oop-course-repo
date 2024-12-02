package oop.practice.lab2.task2;

public class Main {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.MEDIUM, 50);
        Americano americano = new Americano(Intensity.STRONG, 100);

        cappuccino.printCoffeeDetails();
        System.out.println();
        americano.printCoffeeDetails();
    }
}
