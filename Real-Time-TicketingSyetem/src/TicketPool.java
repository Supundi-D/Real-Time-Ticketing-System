import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private Queue<Ticket> tickets; // Use Ticket instead of String

    public TicketPool() {
        tickets = new LinkedList<>();
    }

    // Method to add a ticket to the pool
    public synchronized void addTicket(Ticket ticket) {
        tickets.offer(ticket);  // Accept a Ticket object
    }

    // Method to remove a ticket from the pool
    public synchronized Ticket retrieveTicket() {
        return tickets.poll(); // Retrieve a Ticket or return null if empty
    }

    // Method to check if the pool is empty
    public synchronized boolean isEmpty() {
        return tickets.isEmpty();
    }

    // Method to get the total number of tickets in the pool
    public synchronized int getTicketCount() {
        return tickets.size();
    }
}
