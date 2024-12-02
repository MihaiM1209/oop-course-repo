package oop.practice.lab2.task1;


public class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name = "Coffee";

    public Coffee(Intensity intensity) {
        this.coffeeIntensity = intensity;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public String getName() {
        return name;
    }
}
