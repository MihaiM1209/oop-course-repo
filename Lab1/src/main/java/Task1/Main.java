package Task1;

public class Main {
    public static void main(String[] args) {

        Display d1 = new Display(2560, 1600, 227f, "MacBook Air");
        Display d2 = new Display(3072, 1920, 226f, "MacBook Pro");
        Display d3 = new Display(5120, 2880, 218f, "iMac");

//        d1.compareSize(d2);
//        d1.compareSharpness(d2);
        System.out.println("Display 1 and 2 comparison");
        d1.compareWithMonitor(d2);
        System.out.println("\nDisplay 1 and 3 comparison");
        d1.compareWithMonitor(d3);
        System.out.println("\nDisplay 2 and 3 comparison");
        d2.compareWithMonitor(d3);
    }
}