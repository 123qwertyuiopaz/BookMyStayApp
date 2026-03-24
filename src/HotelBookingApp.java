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

        List<Reservation> bookingHistory = new ArrayList<>();

        bookingHistory.add(new Reservation("Abhi", "Single"));
        bookingHistory.add(new Reservation("Subha", "Double"));
        bookingHistory.add(new Reservation("Vanmathi", "Suite"));

        System.out.println("Booking History and Reporting\n");
        System.out.println("Booking History Report");

        for (Reservation r : bookingHistory) {
            System.out.println("Guest: " + r.guestName + ", Room Type: " + r.roomType);
        }
    }
}
