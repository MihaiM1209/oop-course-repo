package oop.practice.lab2.task3;

public class Main {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.MEDIUM, 110);
        Americano americano = new Americano(Intensity.STRONG, 80);
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.MEDIUM, 100, 30);
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.MEDIUM, 70, SyrupType.VANILLA);

        cappuccino.printCoffeeDetails();
        System.out.println();
        americano.printCoffeeDetails();
        System.out.println();
        pumpkinSpiceLatte.printCoffeeDetails();
        System.out.println();
        syrupCappuccino.printCoffeeDetails();
    }
}
