// UseCase4RoomSearch.java

import java.util.*;

class Room {
    private String type;
    private int beds;
    private int sizeSqft;
    private double pricePerNight;
    private int available;

    public Room(String type, int beds, int sizeSqft, double pricePerNight, int available) {
        this.type = type;
        this.beds = beds;
        this.sizeSqft = sizeSqft;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public String getType() { return type; }
    public int getBeds() { return beds; }
    public int getSizeSqft() { return sizeSqft; }
    public double getPricePerNight() { return pricePerNight; }
    public int getAvailable() { return available; }

    public boolean isAvailable() {
        return available > 0;
    }

    @Override
    public String toString() {
        return type + ":\n" +
                "Beds: " + beds + "\n" +
                "Size: " + sizeSqft + " sqft\n" +
                "Price per night: " + pricePerNight + "\n" +
                "Available: " + available + "\n";
    }
}

class Inventory {
    private List<Room> rooms;

    public Inventory() {
        rooms = new ArrayList<>();
        rooms.add(new Room("Single Room", 1, 250, 1500.0, 5));
        rooms.add(new Room("Double Room", 2, 400, 2500.0, 3));
        rooms.add(new Room("Suite Room", 3, 750, 5000.0, 2));
    }

    // Read-only access: returns a copy of available rooms
    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
}

public class HotelBookingApp {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        System.out.println("Room Search Results:\n");
        List<Room> availableRooms = inventory.getAvailableRooms();

        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available at the moment.");
        } else {
            for (Room room : availableRooms) {
                System.out.println(room);
            }
        }
    }
}