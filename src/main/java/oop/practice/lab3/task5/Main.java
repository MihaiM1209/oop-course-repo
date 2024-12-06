package oop.practice.lab3.task5;

import oop.practice.lab3.task4.CarStation;
import oop.practice.lab3.task4.Semaphore;
import oop.practice.lab3.task2.GasStation;
import oop.practice.lab3.task2.ElectricStation;
import oop.practice.lab3.task1.Car;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize CarStations
        CarStation gasStation = new CarStation(new GasStation());
        CarStation electricStation = new CarStation(new ElectricStation());

        // 2. Create Semaphore
        Semaphore semaphore = new Semaphore(Arrays.asList(gasStation, electricStation));

        // 3. Prompt User for Scheduling Intervals
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the interval (in seconds) for loading cars: ");
        int loadInterval = scanner.nextInt();
        System.out.print("Enter the interval (in seconds) for serving cars: ");
        int serveInterval = scanner.nextInt();

        // 4. Setup Schedulers
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        // 4.1. Car Loading Task
        Runnable carLoadingTask = () -> {
            try {
                System.out.println("Loading cars from queue...");
                semaphore.loadAndRouteCars();
            } catch (Exception e) {
                System.err.println("Error loading cars: " + e.getMessage());
            }
        };

        // 4.2. Car Serving Task
        Runnable carServingTask = () -> {
            try {
                System.out.println("Serving cars at stations...");
                gasStation.serveCars();
                electricStation.serveCars();

                System.out.println("Gas Station served: " + gasStation.getCarsServedCount() + " cars.");
                System.out.println("Electric Station served: " + electricStation.getCarsServedCount() + " cars.");

                // Calculate total consumption
                int totalConsumption = gasStation.getTotalConsumption() + electricStation.getTotalConsumption();
                System.out.println("Total consumption: " + totalConsumption + " units.");

                // Stop the scheduler if all cars are served
                if (semaphore.isQueueEmpty()) {
                    System.out.println("All cars served. Stopping the scheduler...");
                    Runtime.getRuntime().exit(0); // Exit program
                }
            } catch (Exception e) {
                System.err.println("Error serving cars: " + e.getMessage());
            }
        };

        // 5. Schedule Tasks
        scheduler.scheduleAtFixedRate(carLoadingTask, 0, loadInterval, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(carServingTask, 0, serveInterval, TimeUnit.SECONDS);

        // 6. Shutdown Scheduler Gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            scheduler.shutdown();
            System.out.println("Scheduler shutting down.");
        }));
    }
}
