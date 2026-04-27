package main;

public class UseCase20SearchWithValidation {

    // Linear search (used after validation)
    public static boolean searchBogie(String[] bogieIds, String key) {

        // Fail-fast validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train");
        }

        // Normal search logic
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogies = {"BG101", "BG205", "BG309"};

        try {
            boolean result = searchBogie(bogies, "BG205");

            if (result) {
                System.out.println("Bogie found");
            } else {
                System.out.println("Bogie not found");
            }

            // Empty case demo
            String[] empty = {};

            searchBogie(empty, "BG101");

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
}