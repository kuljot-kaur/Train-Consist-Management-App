import java.util.ArrayList;
import java.util.Comparator;
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

        // Create a list to store bogies
        List<Bogie> bogieList = new ArrayList<>();

        // Add passenger bogies
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        // Sort bogies based on capacity (ascending order)
        bogieList.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Display sorted bogies
        System.out.println("--- Bogies Sorted by Capacity ---");
        for (Bogie b : bogieList) {
            System.out.println("Bogie: " + b.getName() +
                    " | Capacity: " + b.getCapacity());
        }
    }
}