import java.util.*;

class Booking {
    String reservationId;
    String roomType;
    boolean isCancelled;

    Booking(String reservationId, String roomType) {
        this.reservationId = reservationId;
        this.roomType = roomType;
        this.isCancelled = false;
    }
}

class CancellationService {

    Map<String, Integer> inventory = new HashMap<>();
    Map<String, Booking> bookings = new HashMap<>();
    Stack<String> rollbackStack = new Stack<>();

    public CancellationService() {
        inventory.put("Single", 5);
    }

    public void addBooking(String reservationId, String roomType) {
        Booking booking = new Booking(reservationId, roomType);
        bookings.put(reservationId, booking);
        inventory.put(roomType, inventory.get(roomType) - 1);
    }

    public void cancelBooking(String reservationId) {

        System.out.println("Booking Cancellation");

        if (!bookings.containsKey(reservationId)) {
            System.out.println("Invalid reservation ID. Cancellation failed.");
            return;
        }

        Booking booking = bookings.get(reservationId);

        if (booking.isCancelled) {
            System.out.println("Booking already cancelled.");
            return;
        }

        rollbackStack.push(reservationId);

        String roomType = booking.roomType;
        inventory.put(roomType, inventory.get(roomType) + 1);

        booking.isCancelled = true;

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);

        System.out.println("\nRollback History (Most Recent First):");
        for (int i = rollbackStack.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + rollbackStack.get(i));
        }

        System.out.println("\nUpdated " + roomType + " Room Availability: " + inventory.get(roomType));
    }
}

public class HotelBookingApp {
    public static void main(String[] args) {

        CancellationService service = new CancellationService();

        service.addBooking("Single-1", "Single");

        service.cancelBooking("Single-1");
    }
}