package Assignment_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LockedMe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // About Me
        System.out.println("******* Simplilearn Assignment 1 ********");
        System.out.println("*****************************************");
        System.out.println("******* Sadasiva  *********************");

        System.out.println("*****************************************");
        System.out.println("******* Full Stack Developer  ************");

        // Display the welcome screen
        System.out.println("Welcome to LockedMe!");
        System.out.println("This application allows you to digitize your products.");
        System.out.println("To get started, please select an option from the menu.");

        while (true) {
            // Create a menu of options
            ArrayList<String> options = new ArrayList<String>();
            options.add("1. List files");
            options.add("2. Add file");
            options.add("3. Delete file");
            options.add("4. Search file");
            options.add("5. Quit");

            // Display the menu options
            for (String option : options) {
                System.out.println(option);
            }

            // Get the user input
            input = scanner.nextLine();

            // Process the user input
            switch (input) {
                case "1":
                    // Display the current file names in ascending order.
                    ArrayList<String> fileNames = new ArrayList<String>();
                    for (File file : new File(".").listFiles()) {
                        fileNames.add(file.getName());
                    }
                    Collections.sort(fileNames);
                    System.out.println("The current file names are:");
                    for (String fileName : fileNames) {
                        System.out.println(fileName);
                    }
                    break;
                case "2":
                    // Add a file to the existing directory list.
                    System.out.println("Enter the name of the file to add: ");
                    String fileName = scanner.nextLine();
                    if (new File(fileName).exists()) {
                        System.out.println("File already exists.");
                    } else {
                        try {
                            new File(fileName).createNewFile();
                            System.out.println("File added successfully.");

                            // Write to the file
                            FileWriter writer = new FileWriter(fileName);
                            System.out.println("Enter the content you want to write to the file: ");
                            String content = scanner.nextLine();
                            writer.write(content);
                            writer.close();
                            System.out.println("Content written to file successfully.");
                        } catch (IOException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case "3":
                    // Delete a user specified file from the existing directory list.
                    System.out.println("Enter the name of the file to delete: ");
                    fileName = scanner.nextLine();
                    if (new File(fileName).exists()) {
                        new File(fileName).delete();
                        System.out.println("File deleted successfully.");
                    } else {
                        System.out.println("File does not exist.");
                    }
                    break;
                case "4":
                    // Search a user specified file from the main directory.
                    System.out.println("Enter the name of the file to search for: ");
                    fileName = scanner.nextLine();
                    File fileToSearch = new File(fileName);
                    try {
                        Scanner fileScanner = new Scanner(fileToSearch);
                        System.out.println("File found: " + fileName);
                        fileScanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "5":
                    // Close the application.
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
            // Asking the user if they want to continue or quit
            System.out.println("Press 'c' to continue or 'q' to quit.");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                // Close the application.
                System.out.println("Goodbye!");
                return;
            } else if (!input.equalsIgnoreCase("c")) {
                System.out.println("Invalid input. Application will continue.");
            }
        }
    }
}