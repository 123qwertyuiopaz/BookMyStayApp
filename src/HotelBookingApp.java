import java.util.*;

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
        bookingQueue.add(new Reservation("Subha", "Single"));
        bookingQueue.add(new Reservation("Vanmathi", "Suite"));

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);

        Map<String, Set<String>> allocatedRooms = new HashMap<>();

        System.out.println("Room Allocation Processing");

        while (!bookingQueue.isEmpty()) {

            Reservation r = bookingQueue.poll();

            String type = r.roomType;

            if (inventory.getOrDefault(type, 0) > 0) {

                allocatedRooms.putIfAbsent(type, new HashSet<>());

                Set<String> roomSet = allocatedRooms.get(type);

                String roomId = type + "-" + (roomSet.size() + 1);

                while (roomSet.contains(roomId)) {
                    roomId = type + "-" + (roomSet.size() + 1);
                }

                roomSet.add(roomId);

                inventory.put(type, inventory.get(type) - 1);

                System.out.println("Booking confirmed for Guest: "
                        + r.guestName + ", Room ID: " + roomId);

            } else {
                System.out.println("Booking failed for Guest: "
                        + r.guestName + " (No " + type + " rooms available)");
            }
        }
    }
}
