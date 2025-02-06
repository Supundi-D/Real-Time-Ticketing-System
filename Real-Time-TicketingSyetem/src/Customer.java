public class Customer implements Runnable {
    private TicketPool ticketPool;
    private int ticketsToRetrieve;
    private int retrievalRate;

    public Customer(TicketPool ticketPool, int ticketsToRetrieve, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.ticketsToRetrieve = ticketsToRetrieve;
        this.retrievalRate = retrievalRate;
    }

    @Override
    public void run() {
        // Retrieve tickets from the pool
        for (int i = 0; i < ticketsToRetrieve; i++) {
            Ticket ticket = ticketPool.retrieveTicket(); // Get a Ticket object, not a String
            if (ticket != null) {
                System.out.println("Customer retrieved: " + ticket); // ticket is now a Ticket object
            } else {
                System.out.println("No tickets available for retrieval");
            }
            try {
                Thread.sleep(retrievalRate); // Simulate time delay for retrieving a ticket
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
