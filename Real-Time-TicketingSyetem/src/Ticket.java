import java.math.BigDecimal;

public class Ticket {
    private int ticketId;
    private String eventName;
    private BigDecimal price;

    public Ticket(int ticketId, String eventName, BigDecimal price) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.price = price;
    }

    // Getter methods
    public int getTicketId() {
        return ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId + ", Event: " + eventName + ", Price: " + price;
    }
}
