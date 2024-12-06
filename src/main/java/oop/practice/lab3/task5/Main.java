package oop.practice.lab3.task5;

import oop.practice.lab3.task4.CarStation;
import oop.practice.lab3.task4.Semaphore;
import oop.practice.lab3.task2.GasStation;
import oop.practice.lab3.task2.ElectricStation;
import oop.practice.lab3.task1.Car;

import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize CarStations
        CarStation gasStation = new CarStation(new GasStation());
        CarStation electricStation = new CarStation(new ElectricStation());

        // 2. Create Semaphore
        Semaphore semaphore = new Semaphore(Arrays.asList(gasStation, electricStation));

        // 3. Setup Schedulers
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // 3.1. Car Loading Task
        Runnable carLoadingTask = () -> {
            try {
                System.out.println("Loading cars from queue...");
                semaphore.loadAndRouteCars();
            } catch (Exception e) {
                System.err.println("Error loading cars: " + e.getMessage());
            }
        };

        // 3.2. Car Serving Task
        Runnable carServingTask = () -> {
            System.out.println("Serving cars at stations...");
            gasStation.serveCars();
            electricStation.serveCars();
            System.out.println("Gas Station served: " + gasStation.getCarsServedCount() + " cars.");
            System.out.println("Electric Station served: " + electricStation.getCarsServedCount() + " cars.");
        };

        // 4. Schedule Tasks
        scheduler.scheduleAtFixedRate(carLoadingTask, 0, 5, TimeUnit.SECONDS); // Load cars every 5 seconds
        scheduler.scheduleAtFixedRate(carServingTask, 0, 10, TimeUnit.SECONDS); // Serve cars every 10 seconds

        // 5. Shutdown Scheduler Gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            scheduler.shutdown();
            System.out.println("Scheduler shutting down...");
        }));
    }
}
