import java.util.LinkedHashSet;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies (LinkedHashSet)");
        System.out.println("=====================================");
        System.out.println();

        // Create LinkedHashSet to store bogies uniquely while preserving insertion order
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to attach duplicate bogie intentionally
        boolean addedDuplicate = trainFormation.add("Sleeper");  // This will be ignored

        // Display if duplicate addition was successful or ignored
        System.out.println("Attempt to add duplicate 'Sleeper': " + (addedDuplicate ? "Added" : "Ignored"));

        // Display final formation order
        System.out.println("Final Train Formation (preserving insertion order, no duplicates):");
        System.out.println(trainFormation);
    }
}