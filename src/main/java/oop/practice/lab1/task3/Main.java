package oop.practice.lab1.task3;

import oop.practice.lab1.task1.Display;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Assistant displayAssistant = new Assistant("Display Assistant");

        // Create new Display objects with different specifications
        Display display1 = new Display(2560, 1600, 227f, "MacBook Air");
        Display display2 = new Display(3072, 1920, 226f, "MacBook Pro");
        Display display3 = new Display(5120, 2880, 218f, "iMac");

        // Assign displays to the assistant
        displayAssistant.assignDisplay(display1);
        displayAssistant.assignDisplay(display2);
        displayAssistant.assignDisplay(display3);

        // Assist with display comparison
        displayAssistant.assist();

        // Purchase a display
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nAvailable displays for purchase:");
        displayAssistant.listAvailableDisplays();  // Method to list available displays

        System.out.print("\nSelect the display number to buy (1-" + displayAssistant.getAssignedDisplaysCount() + "): ");
        int selectedNumber = userInput.nextInt();

        if (selectedNumber > 0 && selectedNumber <= displayAssistant.getAssignedDisplaysCount()) {
            Display chosenDisplay = displayAssistant.getDisplayByIndex(selectedNumber - 1);
            displayAssistant.buyDisplay(chosenDisplay);
        } else {
            System.out.println("Invalid selection. Please choose a valid display number.");
        }

        // Show remaining displays
        System.out.println("\nDisplays remaining after purchase:");
        displayAssistant.listAvailableDisplays();

        userInput.close(); // Close the scanner to prevent resource leaks
    }
}
