import java.util.*;

class Service {
    String name;
    int cost;

    Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}

public class HotelBookingApp {

    public static void main(String[] args) {

        Map<String, List<Service>> serviceMap = new HashMap<>();

        String res1 = "R1";
        String res2 = "R2";

        List<Service> services1 = new ArrayList<>();
        services1.add(new Service("Breakfast", 200));
        services1.add(new Service("WiFi", 100));

        List<Service> services2 = new ArrayList<>();
        services2.add(new Service("Spa", 500));

        serviceMap.put(res1, services1);
        serviceMap.put(res2, services2);

        System.out.println("Add-On Service Selection");

        for (String resId : serviceMap.keySet()) {

            List<Service> list = serviceMap.get(resId);

            int total = 0;

            System.out.println("Reservation ID: " + resId);

            for (Service s : list) {
                System.out.println("Service: " + s.name + ", Cost: " + s.cost);
                total += s.cost;
            }

            System.out.println("Total Add-On Cost: " + total);
        }
    }
}
