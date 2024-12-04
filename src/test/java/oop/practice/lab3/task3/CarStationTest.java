package oop.practice.lab3.task3;


import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task2.DiningService;
import oop.practice.lab3.task2.RefuelingService;
import oop.practice.lab3.task3.CarStation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarStationTest {

    @Test
    public void testCarStationWithQueueData() throws Exception {
        // Create services
        DiningService diningService = new DiningService();
        RefuelingService refuelingService = new RefuelingService();

        // Create CarStation
        CarStation carStation = new CarStation(diningService, refuelingService);

        // Load cars from the queue folder (this simulates reading the files)
        carStation.loadCarsFromQueue();

        // Assert that the cars are loaded correctly
        assertTrue(carStation.carQueue.size() > 0, "There should be at least one car in the queue.");

        // Serve cars
        carStation.serveCars();

        // Verify that all cars have been served and the queue is empty
        assertTrue(carStation.carQueue.isEmpty(), "The car queue should be empty after serving all cars.");
    }
}
