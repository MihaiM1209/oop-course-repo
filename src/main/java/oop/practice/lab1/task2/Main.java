package oop.practice.lab1.task2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide at least one file path as a command-line argument.");
            return;
        }

        for (String filePath : args) {
            try {
                String content = FileReader.readFileIntoString(filePath);  // Read file content
                TextData textData = new TextData(filePath, content);        // Pass file path and content
                textData.printInfo();                                       // Print analysis
            } catch (IOException e) {
                System.err.println("Error reading file '" + filePath + "': " + e.getMessage());
            }
        }
    }
}
