package oop.practice.lab2.task1;


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
}
