import java.math.BigDecimal;

public class Vendor implements Runnable {
    private int totalTickets; // Tickets willing to sell
    private int ticketReleaseRate; // Frequency of releasing
    private TicketPool ticketPool; // Shared resource between Vendors and Customers

    public Vendor(int totalTickets, int ticketReleaseRate, TicketPool ticketPool) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
    }

    @Override
    public void run() {
        for (int i = 1; i <= totalTickets; i++) {  // Changed to <= to include all tickets
            Ticket ticket = new Ticket(i, "Simple Event", new BigDecimal("1000"));
            ticketPool.addTicket(ticket);  // Adds a Ticket object, not a String
            try {
                Thread.sleep(ticketReleaseRate * 1000); // To calculate to milliseconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
