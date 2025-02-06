import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // Initialize TicketPool
        TicketPool ticketPool = new TicketPool(); // Assuming TicketPool is a class

        // Initialize Configuration object
        Configuration configuration = new Configuration();
        configuration.displayConfiguration(); // Display the configuration input prompt

        // Saving to JSON file using the saveToFile method
        try {
            configuration.saveToFile("config.json");
            System.out.println("Configuration saved to config.json");
        } catch (IOException e) {
            System.out.println("Error saving configuration to JSON: " + e.getMessage());
        }

        // Saving configuration to a text file
        try {
            FileWriter writer = new FileWriter("configuration.txt");
            writer.write("Total Tickets: " + configuration.getTotalTickets() + "\n");
            writer.write("Ticket Release Rate: " + configuration.getTicketReleaseRate() + " ms\n");
            writer.write("Customer Retrieval Rate: " + configuration.getCustomerRetrievalRate() + " ms\n");
            writer.write("Max Ticket Capacity: " + configuration.getMaxTicketCapacity() + "\n");
            writer.close();
            System.out.println("Configuration saved to configuration.txt");
        } catch (IOException e) {
            System.out.println("Error saving configuration to text file: " + e.getMessage());
        }

        // Creating array of vendors
        Vendor[] vendors = new Vendor[10];
        for (int i = 0; i < vendors.length; i++) {
            vendors[i] = new Vendor(20, 5, ticketPool); // Pass ticketPool to vendors
            Thread vendorThread = new Thread(vendors[i], "Vendor ID-" + i);
            vendorThread.start();
        }

        // Creating array of customers
        Customer[] customers = new Customer[10];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(ticketPool, 6, 5); // Pass ticketPool to customers
            Thread customerThread = new Thread(customers[i], "Customer ID-" + i);
            customerThread.start();
        }
    }
}
