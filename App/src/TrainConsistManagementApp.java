import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("UC3 - Track Unique Bogie IDs (Set – HashSet)");
        System.out.println("=====================================");
        System.out.println();

        // Initialize HashSet for bogie IDs
        Set<String> bogieIDs = new HashSet<>();

        // Add bogie IDs (with duplicates)
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG101");  // Duplicate
        bogieIDs.add("BG103");
        bogieIDs.add("BG102");  // Duplicate

        // Display final set (duplicates automatically removed)
        System.out.println("Bogie IDs added (duplicates ignored):");
        System.out.println(bogieIDs);
    }
}