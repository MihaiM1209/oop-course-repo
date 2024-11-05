package oop.practice.lab2.task3;

public class Coffee {
    private Intensity coffeeIntensity;

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    // Rename this method to getCoffeeIntensity
    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public String getName() {
        return "Coffee";
    }

    public void printCoffeeDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }
}
