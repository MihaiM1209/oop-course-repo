package oop.practice.lab3.task3;

import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task2.Dineable;
import oop.practice.lab3.task2.Refuelable;

import java.util.LinkedList;
import java.util.Queue;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    Queue<Car> carQueue;

    // Constructor to initialize dependencies and queue
    public CarStation(Dineable diningService, Refuelable refuelingService) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.carQueue = new LinkedList<>(); // Initialize the queue
    }

    // Adds a car to the queue
    public void addCar(Car car) {
        carQueue.add(car);
        System.out.println("Added car to queue: " + car.getId());
    }

    // Serves all cars in the queue
    public void serveCars() {
        while (!carQueue.isEmpty()) {
            Car car = carQueue.poll(); // Get and remove the first car in the queue
            System.out.println("Serving car with ID: " + car.getId());

            // Serve dinner if needed
            if (car.isDining()) {
                diningService.serveDinner(car.getId());
            }

            // Refuel the car
            refuelingService.refuel(car.getId());

            System.out.println("Finished serving car with ID: " + car.getId());
        }
    }
}
