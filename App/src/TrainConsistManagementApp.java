import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("UC4 - Maintain Ordered Bogie IDs (LinkedList)");
        System.out.println("=====================================");
        System.out.println();

        // Create LinkedList for train consist bogie IDs
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies in order: Engine, Sleeper, AC, Cargo, Guard
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // Insert Pantry Car at position 2 (index starts at 0)
        trainConsist.add(2, "Pantry Car");

        // Remove the first bogie
        String removedFirst = trainConsist.removeFirst();

        // Remove the last bogie
        String removedLast = trainConsist.removeLast();

        // Display the final ordered train consist
        System.out.println("Final Train Consist after modifications:");
        System.out.println(trainConsist);
    }
}