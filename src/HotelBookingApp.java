import java.util.*;

class BookingRequest {
    String guestName;
    String roomType;

    BookingRequest(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

class BookingSystem {

    Map<String, Integer> inventory = new HashMap<>();
    Map<String, Integer> roomCounter = new HashMap<>();
    Queue<BookingRequest> queue = new LinkedList<>();

    public BookingSystem() {
        inventory.put("Single", 5);
        inventory.put("Double", 3);
        inventory.put("Suite", 2);

        roomCounter.put("Single", 0);
        roomCounter.put("Double", 0);
        roomCounter.put("Suite", 0);
    }

    public synchronized void addRequest(BookingRequest request) {
        queue.add(request);
    }

    public synchronized BookingRequest getRequest() {
        return queue.poll();
    }

    public synchronized void processBooking(BookingRequest request) {

        String type = request.roomType;

        if (inventory.get(type) > 0) {
            inventory.put(type, inventory.get(type) - 1);

            int count = roomCounter.get(type) + 1;
            roomCounter.put(type, count);

            String roomId = type + "-" + count;

            System.out.println("Booking confirmed for Guest: " + request.guestName + ", Room ID: " + roomId);
        } else {
            System.out.println("No rooms available for Guest: " + request.guestName);
        }
    }

    public void printInventory() {
        System.out.println("\nRemaining Inventory:");
        for (String type : inventory.keySet()) {
            System.out.println(type + ": " + inventory.get(type));
        }
    }
}

class BookingProcessor extends Thread {

    BookingSystem system;

    BookingProcessor(BookingSystem system) {
        this.system = system;
    }

    public void run() {
        while (true) {
            BookingRequest request;

            synchronized (system) {
                request = system.getRequest();
            }

            if (request == null) break;

            system.processBooking(request);
        }
    }
}

public class HotelBookingApp {
    public static void main(String[] args) throws InterruptedException {

        BookingSystem system = new BookingSystem();

        system.addRequest(new BookingRequest("Abhi", "Single"));
        system.addRequest(new BookingRequest("Vanmathi", "Double"));
        system.addRequest(new BookingRequest("Kural", "Suite"));
        system.addRequest(new BookingRequest("Subha", "Single"));

        Thread t1 = new BookingProcessor(system);
        Thread t2 = new BookingProcessor(system);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        system.printInventory();
    }
}