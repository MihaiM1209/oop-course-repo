package oop.practice.lab2.task1;


public class PumpkinSpiceLatte extends Coffee {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(Intensity intensity, int mgOfPumpkinSpice) {
        super(intensity);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    @Override
    public String getName() {
        return "PumpkinSpiceLatte";
    }
}
