package main;

public class UseCase18LinearSearch {

    // Linear Search Method
    public static boolean searchBogie(String[] bogieIds, String key) {

        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true; // match found
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        String searchKey = "BG309";

        boolean found = searchBogie(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie ID found: " + searchKey);
        } else {
            System.out.println("Bogie ID not found: " + searchKey);
        }
    }
}