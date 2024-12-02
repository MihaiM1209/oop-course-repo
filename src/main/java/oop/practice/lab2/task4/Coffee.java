package oop.practice.lab2.task4;

public abstract class Coffee {
    private Intensity coffeeIntensity;

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    // Abstract method to be implemented by each subclass for specific coffee details
    public abstract String getName();

    // Standardized method to print coffee details; subclasses will override as needed
    public void printCoffeeDetails() {
        System.out.println("Making " + getName());
        System.out.println("Intensity set to " + coffeeIntensity);
    }
}
