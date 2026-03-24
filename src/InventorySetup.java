
import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, Integer> inventory;

    // Constructor initializes room availability
    public RoomInventory(Map<String, Integer> initialAvailability) {
        this.inventory = new HashMap<>(initialAvailability);
    }

    // Method to get current availability of a room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Method to update availability in a controlled way
    public void updateAvailability(String roomType, int newCount) {
        if (newCount >= 0) {
            inventory.put(roomType, newCount);
        } else {
            System.out.println("Invalid update: availability cannot be negative.");
        }
    }

    // Method to display current inventory state
    public void displayInventory() {
        System.out.println("HOTEL room  Inventory  status:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

public class InventorySetup {
    public static void main(String[] args) {
        Map<String, Integer> initialAvailability = new HashMap<>();
        initialAvailability.put("Single", 10);
        initialAvailability.put("Double", 5);
        initialAvailability.put("Suite", 2);
        RoomInventory roomInventory = new RoomInventory(initialAvailability);
        roomInventory.displayInventory();
        roomInventory.updateAvailability("Single", 8);
        roomInventory.updateAvailability("Suite", 1);
        roomInventory.displayInventory();
        System.out.println("Available Double Rooms: " + roomInventory.getAvailability("Double"));
    }
}
