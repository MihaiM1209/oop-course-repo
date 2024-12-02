package oop.practice.lab2.task4;

public class PumpkinSpiceLatte extends Coffee {
    private int mlOfMilk;
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    @Override
    public String getName() {
        return "Pumpkin Spice Latte";
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Adding " + mlOfMilk + " mls of milk");
        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkin spice");
    }
}
