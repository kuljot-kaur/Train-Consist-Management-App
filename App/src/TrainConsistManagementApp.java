import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("UC2 - Add Passenger Bogies to Train");
        System.out.println("=====================================");
        System.out.println();

        // Initialize passenger bogies list
        List<String> passengerBogies = new ArrayList<>();

        // Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Print after adding bogies
        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies);
        System.out.println();

        // Remove 'AC Chair'
        passengerBogies.remove("AC Chair");
        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + passengerBogies);
        System.out.println();

        // Check if 'Sleeper' exists
        System.out.println("Checking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper"));
        System.out.println();

        // Final consist print
        System.out.println("Final Train Passenger Consist:");
        System.out.println(passengerBogies);
        System.out.println();

        System.out.println("UC2 operations completed successfully...");
    }
}