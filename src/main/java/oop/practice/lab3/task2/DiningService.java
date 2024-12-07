package oop.practice.lab3.task2;


public class DiningService implements Dineable {
    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to car with ID: " + carId);
    }
}

