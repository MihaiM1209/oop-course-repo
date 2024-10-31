package oop.practice.lab1.task3;

import oop.practice.lab1.task1.Display;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String name;
    private List<Display> displays;

    public Assistant(String name) {
        this.name = name;
        this.displays = new ArrayList<>();
    }

    // Assigns a Display object to the assistant
    public void assignDisplay(Display display) {
        displays.add(display);
        System.out.println("Assigned display: " + display.getModel());
    }

    // Assists with comparing the displays
    public void assist() {
        System.out.println("\nAssisting with display comparisons for " + name + "...");
        if (displays.isEmpty()) {
            System.out.println("No displays assigned.");
            return;
        }

        // Compare each display with every other display
        for (int i = 0; i < displays.size(); i++) {
            Display currentDisplay = displays.get(i);
            for (int j = i + 1; j < displays.size(); j++) {
                Display otherDisplay = displays.get(j);
                System.out.println("\nComparing " + currentDisplay.getModel() + " with " + otherDisplay.getModel() + ":");
                currentDisplay.compareWithMonitor(otherDisplay); // Assuming this method exists in Display
            }
        }
    }

    // Buys a display if it's available
    public Display buyDisplay(Display display) {
        if (displays.remove(display)) {
            System.out.println("Purchased display: " + display.getModel());
            return display;
        } else {
            System.out.println("Display not found.");
            return null;
        }
    }

    // Returns the count of assigned displays
    public int getAssignedDisplaysCount() {
        return displays.size();
    }

    // Returns the Display object at a specific index
    public Display getDisplayByIndex(int index) {
        return displays.get(index);
    }

    // Lists all available displays for purchase
    public void listAvailableDisplays() {
        if (displays.isEmpty()) {
            System.out.println("No displays available for purchase.");
            return;
        }

        for (int i = 0; i < displays.size(); i++) {
            System.out.println((i + 1) + ". " + displays.get(i).getModel());
        }
    }
}
