package oop.practice.lab3.task2;

public class CarServiceStation {
    private Dineable diningService;
    private Refuelable refuelingService;

    public CarServiceStation(Dineable diningService, Refuelable refuelingService) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
    }

    public void serveCars(String carId, boolean isElectric, boolean isDining) {
        if (isDining) {
            diningService.serveDinner(carId);
        }

        if (isElectric) {
            refuelingService.refuel(carId);
        } else {
            ((GasStation) refuelingService).refuel(carId);
        }
    }
}

