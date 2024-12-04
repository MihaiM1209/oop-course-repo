package oop.practice.lab3.task4;

import com.fasterxml.jackson.databind.ObjectMapper;
import oop.practice.lab3.task1.Car;

import java.io.File;
import java.util.List;

public class Semaphore {
    private final List<CarStation> stations;

    public Semaphore(List<CarStation> stations) {
        this.stations = stations;
    }

    // Load cars from the `queue` directory and route them to appropriate stations
    public void loadAndRouteCars() throws Exception {
        File queueFolder = new File("src/main/java/oop/practice/lab3/generator/queue");
        File[] files = queueFolder.listFiles((dir, name) -> name.endsWith(".json"));

        if (files == null || files.length == 0) {
            System.out.println("No car files found in the queue folder.");
            return;
        }

        ObjectMapper objectMapper = new ObjectMapper();

        for (File file : files) {
            Car car = objectMapper.readValue(file, Car.class); // Deserialize car from JSON
            routeCar(car); // Route the car to the appropriate station
        }
    }

    // Routes a car to an appropriate station
    private void routeCar(Car car) {
        for (CarStation station : stations) {
            if (station.acceptsCar(car)) {
                station.addCar(car);
                return;
            }
        }
        throw new IllegalArgumentException("No suitable CarStation found for car: " + car);
    }
}
