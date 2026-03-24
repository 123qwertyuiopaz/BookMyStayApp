import java.io.*;
import java.util.*;

class InventoryData implements Serializable {
    Map<String, Integer> inventory;

    InventoryData(Map<String, Integer> inventory) {
        this.inventory = inventory;
    }
}

class PersistenceService {

    private static final String FILE_NAME = "inventory.dat";

    public static void save(Map<String, Integer> inventory) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(new InventoryData(inventory));
            oos.close();
            System.out.println("Inventory saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving inventory.");
        }
    }

    public static Map<String, Integer> load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            InventoryData data = (InventoryData) ois.readObject();
            ois.close();
            return data.inventory;
        } catch (Exception e) {
            return null;
        }
    }
}

public class HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        Map<String, Integer> inventory = PersistenceService.load();

        if (inventory == null) {
            System.out.println("No valid inventory data found. Starting fresh.");
            inventory = new HashMap<>();
            inventory.put("Single", 5);
            inventory.put("Double", 3);
            inventory.put("Suite", 2);
        }

        System.out.println("\nCurrent Inventory:");
        for (String type : inventory.keySet()) {
            System.out.println(type + ": " + inventory.get(type));
        }

        PersistenceService.save(inventory);
    }
}