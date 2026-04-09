import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        // Create and populate bogie list (same as UC7)
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Luxury Coach", 80));

        // Filter bogies with capacity greater than 60
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > 60)   // condition
                .collect(Collectors.toList());       // collect into new list

        // Display filtered bogies
        System.out.println("--- Filtered Bogies (Capacity > 60) ---");
        for (Bogie b : filteredBogies) {
            System.out.println("Bogie: " + b.getName() +
                    " | Capacity: " + b.getCapacity());
        }

        // Show original list remains unchanged
        System.out.println("\n--- Original Bogie List ---");
        for (Bogie b : bogieList) {
            System.out.println("Bogie: " + b.getName() +
                    " | Capacity: " + b.getCapacity());
        }
    }
}