package oop.practice.lab2.task2;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) {
        super(intensity, mlOfMilk);
        this.syrup = syrup;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    @Override
    public String getName() {
        return "Syrup Cappuccino";
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println("Making " + getName());
        System.out.println("Intensity set to " + getCoffeeIntensity());
        System.out.println("Adding " + getMlOfMilk() + " mls of milk");
        System.out.println("Adding syrup flavor: " + syrup);
    }
}
