import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        // Create bogie list
        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("Sleeper", 70));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("AC Chair", 60));

        // Group bogies by type (name)
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Display grouped result
        System.out.println("--- Grouped Bogies by Type ---");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Bogie Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("   Capacity: " + b.getCapacity());
            }
        }

        // Show original list remains unchanged
        System.out.println("\n--- Original Bogie List ---");
        for (Bogie b : bogieList) {
            System.out.println("Bogie: " + b.getName() +
                    " | Capacity: " + b.getCapacity());
        }
    }
}