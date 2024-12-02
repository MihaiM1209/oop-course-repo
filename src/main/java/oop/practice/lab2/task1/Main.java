package oop.practice.lab2.task1;

public class Main {
    public static void main(String[] args) {
        Coffee basicCoffee = new Coffee(Intensity.NORMAL);
        System.out.println(basicCoffee.getName() + " - Intensity: " + basicCoffee.getCoffeeIntensity());

        Cappuccino cappuccino = new Cappuccino(Intensity.STRONG, 200);
        System.out.println(cappuccino.getName() + " - Intensity: " + cappuccino.getCoffeeIntensity() + ", Milk: " + cappuccino.getMlOfMilk() + "ml");

        Americano americano = new Americano(Intensity.LIGHT, 300);
        System.out.println(americano.getName() + " - Intensity: " + americano.getCoffeeIntensity() + ", Water: " + americano.getMlOfWater() + "ml");

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 150);
        System.out.println(pumpkinSpiceLatte.getName() + " - Intensity: " + pumpkinSpiceLatte.getCoffeeIntensity() + ", Pumpkin Spice: " + pumpkinSpiceLatte.getMgOfPumpkinSpice() + "mg");

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.STRONG, 150, SyrupType.VANILLA);
        System.out.println(syrupCappuccino.getName() + " - Intensity: " + syrupCappuccino.getCoffeeIntensity() + ", Milk: " + syrupCappuccino.getMlOfMilk() + "ml, Syrup: " + syrupCappuccino.getSyrup());
    }
}
