package oop.practice.lab2.task4;

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
        super.printCoffeeDetails();
        System.out.println("Adding syrup of type: " + syrup);
    }
}
