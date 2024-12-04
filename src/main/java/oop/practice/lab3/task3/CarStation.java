package oop.practice.lab3.task3;

import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task2.Dineable;
import oop.practice.lab3.task2.Refuelable;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
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

    // Method to load cars from the `queue/` folder
    public void loadCarsFromQueue() throws Exception {
        File queueFolder = new File("src/main/java/oop/practice/lab3/generator/queue");  // Correct folder path
        File[] files = queueFolder.listFiles((dir, name) -> name.endsWith(".json")); // Only JSON files

        if (files == null || files.length == 0) {
            System.out.println("No JSON files found in the queue folder.");
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper to read JSON files

        for (File file : files) {
            Car car = objectMapper.readValue(file, Car.class); // Deserialize into Car object
            addCar(car); // Add car to the queue
        }
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
