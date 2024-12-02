package oop.practice.lab2.task3;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    @Override
    public String getName() {
        return "Americano";
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println("Making " + getName());
        System.out.println("Intensity set to " + getCoffeeIntensity());
        System.out.println("Adding " + mlOfWater + " mls of water");
    }
}
