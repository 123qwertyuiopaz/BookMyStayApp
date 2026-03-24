
abstract class Room {
    private String roomType;
    private int numberOfBeds;
    private double size;
    private double price;

    public Room(String roomType, int numberOfBeds, double size, double price) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.size = size;
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public abstract void displayRoomDetails();
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 20.0, 50.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println(getRoomType()+":");
        System.out.println("Beds: " + getNumberOfBeds());
        System.out.println("Size: " + getSize() + " sqm");
        System.out.println("Price per night: " + getPrice() + " per night");
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 35.0, 90.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println(getRoomType()+":");
        System.out.println("Beds: " + getNumberOfBeds());
        System.out.println("Size: " + getSize() + " sqm");
        System.out.println("Price per night: " + getPrice() + " per night");
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 60.0, 200.0);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println(getRoomType()+":");
        System.out.println("Beds: " + getNumberOfBeds());
        System.out.println("Size: " + getSize() + " sqm");
        System.out.println("Price per night: " + getPrice() + " per night");
    }
}

public class RoomInitialization {
    public static void main(String[] args) {
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        Room single = new SingleRoom();
        Room doubleR = new DoubleRoom();
        Room suite = new SuiteRoom();


        single.displayRoomDetails();
        System.out.println("Availability: " + singleRoomAvailability + " rooms\n");

        doubleR.displayRoomDetails();
        System.out.println("Availability: " + doubleRoomAvailability + " rooms\n");

        suite.displayRoomDetails();
        System.out.println("Availability: " + suiteRoomAvailability + " rooms\n");

    }
}
