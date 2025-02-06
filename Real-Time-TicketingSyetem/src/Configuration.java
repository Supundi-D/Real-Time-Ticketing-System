import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Configuration {
    private int totalTickets;
    private int maxTicketCapacity;
    private int ticketReleaseRate;
    private int customerRetrievalRate;

    // Getters for the configuration parameters
    public int getTotalTickets() {
        return totalTickets;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    // Method to prompt user for input and handle invalid input
    public void displayConfiguration() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Real-Time Ticketing System!");

        // Asking for configuration parameters with error handling
        totalTickets = getValidInput(scanner, "Enter total tickets: ");
        maxTicketCapacity = getValidInput(scanner, "Enter max ticket capacity: ");

        if (totalTickets > maxTicketCapacity) {
            System.out.println("Error: Total tickets exceeded the maximum ticket capacity!");
            totalTickets = getValidInput(scanner, "Enter total tickets: ");
        }

        ticketReleaseRate = getValidInput(scanner, "Enter vendor ticket release rate: ");
        customerRetrievalRate = getValidInput(scanner, "Enter customer ticket retrieval rate: ");

        scanner.close();
    }

    // Method to get a valid integer input from the user
    private int getValidInput(Scanner scanner, String prompt) {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(prompt);
                value = scanner.nextInt();
                valid = true;  // Valid input, break the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();  // Clear the buffer
            }
        }

        return value;
    }

    // Method to save the configuration to a text file
    public void saveToFile(String filename) throws IOException {
        // Use try-with-resources to handle closing the FileWriter automatically
        try (FileWriter writer = new FileWriter(filename)) {
            // Write the configuration parameters to the file
            writer.write("Total Tickets: " + totalTickets + "\n");
            writer.write("Ticket Release Rate: " + ticketReleaseRate + " per second\n");
            writer.write("Customer Retrieval Rate: " + customerRetrievalRate + " per second\n");
            writer.write("Max Ticket Capacity: " + maxTicketCapacity + "\n");

            System.out.println("Configuration successfully saved to " + filename);  // Confirmation message
        } catch (IOException e) {
            System.out.println("Error saving configuration: " + e.getMessage());
            e.printStackTrace();  // Print stack trace for better error diagnostics
        }
    }
}
