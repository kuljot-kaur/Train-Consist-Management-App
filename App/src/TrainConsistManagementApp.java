import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Create HashMap to store bogie-capacity mapping
        HashMap<String, Integer> bogieCapacityMap = new HashMap<>();

        // Ask user for number of bogies
        System.out.print("Enter number of bogies: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Input bogie names and capacities
        for (int i = 0; i < n; i++) {
            System.out.print("Enter bogie name: ");
            String bogieName = scanner.nextLine();

            System.out.print("Enter capacity for " + bogieName + ": ");
            int capacity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // Insert into HashMap
            bogieCapacityMap.put(bogieName, capacity);
        }

        // Display bogie-capacity mapping
        System.out.println("\n--- Bogie Capacity Details ---");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println("Bogie: " + entry.getKey() +
                    " | Capacity: " + entry.getValue());
        }

        scanner.close();
    }
}