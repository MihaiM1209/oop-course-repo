package oop.practice.lab3.task2;

public class ElectricStation implements Refuelable {
    @Override
    public void refuel(String carId) {
        System.out.println("Charging electric car " + carId);
    }
}
