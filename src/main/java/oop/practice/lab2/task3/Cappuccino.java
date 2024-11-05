package oop.practice.lab2.task3;

public class Cappuccino extends Coffee {
    private int mlOfMilk;

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    @Override
    public String getName() {
        return "Cappuccino";
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println("Making " + getName());
        System.out.println("Intensity set to " + getCoffeeIntensity());
        System.out.println("Adding " + mlOfMilk + " mls of milk");
    }
}
