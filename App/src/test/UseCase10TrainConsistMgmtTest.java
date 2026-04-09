import main.UseCase10TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    UseCase10TrainConsistMgmt uc10 = new UseCase10TrainConsistMgmt();

    @Test
    void testReduce_TotalSeatCalculation() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase10TrainConsistMgmt.Bogie("Sleeper", 50),
                new UseCase10TrainConsistMgmt.Bogie("AC Chair", 70),
                new UseCase10TrainConsistMgmt.Bogie("First Class", 40)
        );
        int total = uc10.calculateTotalSeatingCapacity(bogies);
        assertEquals(160, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase10TrainConsistMgmt.Bogie("Sleeper", 30),
                new UseCase10TrainConsistMgmt.Bogie("AC Chair", 20),
                new UseCase10TrainConsistMgmt.Bogie("First Class", 25)
        );
        int total = uc10.calculateTotalSeatingCapacity(bogies);
        assertEquals(75, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Collections.singletonList(
                new UseCase10TrainConsistMgmt.Bogie("Sleeper", 100)
        );
        int total = uc10.calculateTotalSeatingCapacity(bogies);
        assertEquals(100, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Collections.emptyList();
        int total = uc10.calculateTotalSeatingCapacity(bogies);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase10TrainConsistMgmt.Bogie("Sleeper", 45),
                new UseCase10TrainConsistMgmt.Bogie("AC Chair", 55)
        );
        int total = uc10.calculateTotalSeatingCapacity(bogies);
        // Sum should be exactly the sum of capacities
        assertEquals(45 + 55, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase10TrainConsistMgmt.Bogie("Sleeper", 10),
                new UseCase10TrainConsistMgmt.Bogie("AC Chair", 20),
                new UseCase10TrainConsistMgmt.Bogie("First Class", 30),
                new UseCase10TrainConsistMgmt.Bogie("Sleeper", 40)
        );
        int total = uc10.calculateTotalSeatingCapacity(bogies);
        assertEquals(10 + 20 + 30 + 40, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<UseCase10TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("Sleeper", 70));
        bogies.add(new UseCase10TrainConsistMgmt.Bogie("AC Chair", 30));
        int originalSize = bogies.size();

        uc10.calculateTotalSeatingCapacity(bogies);

        // Original list should remain unchanged
        assertEquals(originalSize, bogies.size());
    }
}