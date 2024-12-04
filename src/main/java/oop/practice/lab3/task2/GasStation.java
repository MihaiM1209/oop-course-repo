package oop.practice.lab3.task2;

public class GasStation implements Refuelable {
    @Override
    public void refuel(String carId) {
        System.out.println("Refueling gas car " + carId);
    }

    @Override
    public void refuel(int id) {

    }
}
