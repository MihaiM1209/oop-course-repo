package oop.practice.lab2.task2;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public String getName() {
        return "Americano";
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Americano water: " + mlOfWater + " ml");
    }
}
