import java.util.Queue;
import java.util.LinkedList;


class Reservation {
    String guestName;
    String roomType;


    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}


public class HotelBookingApp {

    public static void main(String[] args) {

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Abhi", "Single"));
        bookingQueue.add(new Reservation("Subha", "Double"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));

        System.out.println("Booking Request Queue");

        while (!bookingQueue.isEmpty()) {
            Reservation r = bookingQueue.poll();
            System.out.println("Processing booking for Guest: "
                    + r.guestName + ", Room Type: " + r.roomType);
        }
    }
}
