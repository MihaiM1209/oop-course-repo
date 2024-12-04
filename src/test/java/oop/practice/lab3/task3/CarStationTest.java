package oop.practice.lab3.task3;

import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task2.DiningService;
import oop.practice.lab3.task2.RefuelingService;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarStationTest {

    @Test
    public void testCarStationWithRandomInput() {
        // Create services
        DiningService diningService = new DiningService();
        RefuelingService refuelingService = new RefuelingService();
        CarStation carStation = new CarStation(diningService, refuelingService);

        // Random generator
        Random random = new Random();

        // Add 5 randomly generated cars
        for (int i = 1; i <= 5; i++) {
            String id = String.valueOf(i);
            String type = random.nextBoolean() ? "Electric" : "Petrol";  // Random type
            String passengers = random.nextBoolean() ? "Private" : "Commercial";  // Random passengers
            boolean isDining = random.nextBoolean();  // Random dining
            int consumption = 10 + random.nextInt(41);  // Random value between 10 and 50

            Car car = new Car(id, type, passengers, isDining, consumption);
            carStation.addCar(car);
        }

        // Serve cars
        carStation.serveCars();

        // Verify that all cars have been served
        assertTrue(carStation.carQueue.isEmpty());
    }
}
