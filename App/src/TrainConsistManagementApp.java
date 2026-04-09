import java.util.ArrayList;
import java.util.List;

class Bogie {
    private String name;
    private int capacity;

    // Constructor
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Create bogie list
        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 70));

        // Calculate total seating capacity using Stream API
        int totalCapacity = bogieList.stream()
                .map(b -> b.getCapacity())     // extract capacity
                .reduce(0, Integer::sum);      // aggregate (sum)

        // Display total capacity
        System.out.println("--- Total Seating Capacity ---");
        System.out.println("Total Seats in Train: " + totalCapacity);

        // Show original list remains unchanged
        System.out.println("\n--- Original Bogie List ---");
        for (Bogie b : bogieList) {
            System.out.println("Bogie: " + b.getName() +
                    " | Capacity: " + b.getCapacity());
        }
    }
}