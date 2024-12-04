package oop.practice.lab3.task1;

// Car.java
public class Car {
    private String id;
    private String type;        // ELECTRIC / GAS
    private String passengers;  // PEOPLE / ROBOTS
    private boolean isDining;   // true / false
    private int consumption;    // 10 - 50

    public Car(String id, String type, String passengers, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPassengers() {
        return passengers;
    }

    public boolean isDining() {
        return isDining;
    }

    public int getConsumption() {
        return consumption;
    }

    @Override
    public String toString() {
        return "Car{id=" + id +
                ", type='" + type + '\'' +
                ", passengers='" + passengers + '\'' +
                ", isDining=" + isDining +
                ", consumption=" + consumption +
                '}';
    }
}
