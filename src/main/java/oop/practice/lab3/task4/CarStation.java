package oop.practice.lab3.task4;

import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task2.Refuelable;

import java.util.LinkedList;
import java.util.Queue;

public class CarStation {
    private Refuelable refuelingService;
    private Queue<Car> carQueue;
    private int carsServedCount; // New variable to track cars served

    // Constructor
    public CarStation(Refuelable refuelingService) {
        this.refuelingService = refuelingService;
        this.carQueue = new LinkedList<>();
        this.carsServedCount = 0;
    }
    public int getTotalConsumption() {
        return carQueue.stream().mapToInt(Car::getConsumption).sum();
    }

    // Determines if this station can accept the given car
    public boolean acceptsCar(Car car) {
        if ("ELECTRIC".equals(car.getType()) && refuelingService instanceof oop.practice.lab3.task2.ElectricStation) {
            return true;
        } else if ("GAS".equals(car.getType()) && refuelingService instanceof oop.practice.lab3.task2.GasStation) {
            return true;
        }
        return false;
    }

    // Adds a car to the station queue
    public void addCar(Car car) {
        carQueue.add(car);
        System.out.println("Added car with ID: " + car.getId() + " to " + refuelingService.getClass().getSimpleName());
    }

    // Serves all cars in the queue
    public void serveCars() {
        while (!carQueue.isEmpty()) {
            Car car = carQueue.poll();
            System.out.println("Serving car with ID: " + car.getId());
            refuelingService.refuel(car.getId());
            carsServedCount++; // Track number of cars served
            System.out.println("Finished serving car with ID: " + car.getId());
        }
    }

    // Returns the number of cars served
    public int getCarsServedCount() {
        return carsServedCount;
    }

}
