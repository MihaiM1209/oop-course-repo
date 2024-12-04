package oop.practice.lab3.task1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String id;
    private String type;
    private String passengers;

    @JsonProperty("isDining") // This maps "isDining" in the JSON to the "dining" field in the Car class
    private boolean dining;

    private int consumption;

    public Car() {}

    public Car(String id, String type, String passengers, boolean dining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.dining = dining;
        this.consumption = consumption;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public boolean isDining() {
        return dining;
    }

    public void setDining(boolean dining) {
        this.dining = dining;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "Car{id='" + id + "', type='" + type + "', passengers='" + passengers + "', dining=" + dining + ", consumption=" + consumption + '}';
    }
}
