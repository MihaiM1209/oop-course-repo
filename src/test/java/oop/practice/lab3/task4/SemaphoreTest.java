package oop.practice.lab3.task4;

import oop.practice.lab3.task1.Car;
import oop.practice.lab3.task2.ElectricStation;
import oop.practice.lab3.task2.GasStation;
import oop.practice.lab3.task4.CarStation;
import oop.practice.lab3.task4.Semaphore;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SemaphoreTest {

    @Test
    void testSemaphoreWithGeneratedCars() {
        // Create CarStations
        CarStation electricStation = new CarStation(new ElectricStation());
        CarStation gasStation = new CarStation(new GasStation());

        // Add stations to the list
        List<CarStation> stations = new ArrayList<>();
        stations.add(electricStation);
        stations.add(gasStation);

        // Create Semaphore
        Semaphore semaphore = new Semaphore(stations);

        // Load and route cars
        assertDoesNotThrow(() -> semaphore.loadAndRouteCars());

        // Serve cars at each station
        electricStation.serveCars();
        gasStation.serveCars();
    }
}
