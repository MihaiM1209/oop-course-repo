package oop.practice.lab3.task2;

import org.junit.jupiter.api.Test;

public class CarServiceStationTest {

    @Test
    public void testServeDinnerAndRefuelElectricCar() {
        Dineable peopleDinner = new PeopleDinner();
        Refuelable electricStation = new ElectricStation();
        CarServiceStation station = new CarServiceStation(peopleDinner, electricStation);

        System.out.println("Test: Serving dinner and refueling electric car");
        station.serveCars("1", true, true);  // Electric car, dining
    }

    @Test
    public void testServeDinnerAndRefuelGasCar() {
        Dineable robotDinner = new RobotDinner();
        Refuelable gasStation = new GasStation();
        CarServiceStation station = new CarServiceStation(robotDinner, gasStation);

        // Print the output to show the result
        System.out.println("Test: Serving dinner and refueling gas car");
        station.serveCars("2", false, true);  // Gas car, dining
    }
}
