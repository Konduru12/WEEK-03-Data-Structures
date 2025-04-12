class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;
    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
public class OnlineTicketReservationSystem{
    private TicketNode tail = null;
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (tail == null) {
            tail = newTicket;
            tail.next = tail;
        } else {
            newTicket.next = tail.next;
            tail.next = newTicket;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully.");
    }
    public void removeTicket(int ticketId) {
        if (tail == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        TicketNode current = tail.next;
        TicketNode prev = tail;
        boolean found = false;
        do {
            if (current.ticketId == ticketId) {
                found = true;
                if (current == tail && current == tail.next) { 
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Ticket ID " + ticketId + " cancelled.");
                break;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
        if (!found) {
            System.out.println("Ticket ID not found.");
        }
    }
    public void displayTickets() {
        if (tail == null) {
            System.out.println("No booked tickets.");
            return;
        }
        TicketNode current = tail.next;
        System.out.println("Current Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != tail.next);
    }
    public void searchTicket(String query) {
        if (tail == null) {
            System.out.println("No tickets to search.");
            return;
        }
        TicketNode current = tail.next;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found Ticket - ID: " + current.ticketId + ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != tail.next);
        if (!found) {
            System.out.println("No tickets found for query: " + query);
        }
    }
    public int countTickets() {
        if (tail == null) return 0;
        int count = 0;
        TicketNode current = tail.next;
        do {
            count++;
            current = current.next;
        } while (current != tail.next);
        return count;
    }
    public static void main(String[] args) {
        OnlineTicketReservationSystem system = new OnlineTicketReservationSystem();
        system.addTicket(101, "Sasanka", "Avengers", "A1", "10:00 AM");
        system.addTicket(102, "Bharath", "Avengers", "A2", "10:00 AM");
        system.addTicket(103, "Abhi", "Batman", "B1", "12:00 PM");
        system.displayTickets();
        system.searchTicket("Avengers");
        system.searchTicket("Bharath");
        System.out.println("Total booked tickets: " + system.countTickets());
        system.removeTicket(102);
        system.displayTickets();
        System.out.println("Total booked tickets: " + system.countTickets());
    }
}

