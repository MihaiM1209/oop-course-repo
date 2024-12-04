package oop.practice.lab3.task2;

public class RefuelingService implements Refuelable {
    @Override
    public void refuel(String carId) {
        System.out.println("Refueling car with ID: " + carId);
    }

    @Override
    public void refuel(int id) {

    }
}

