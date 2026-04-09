import main.UseCase8TrainConsistMgmt;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmtTest {

    UseCase8TrainConsistMgmt uc8 = new UseCase8TrainConsistMgmt();

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase8TrainConsistMgmt.Bogie("AC Chair", 65),
                new UseCase8TrainConsistMgmt.Bogie("First Class", 50)
        );
        List<UseCase8TrainConsistMgmt.Bogie> filtered = uc8.filterBogiesByCapacity(bogies, 70);
        assertEquals(1, filtered.size());
        assertEquals("Sleeper", filtered.get(0).getName());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Sleeper", 70),
                new UseCase8TrainConsistMgmt.Bogie("AC Chair", 80)
        );
        List<UseCase8TrainConsistMgmt.Bogie> filtered = uc8.filterBogiesByCapacity(bogies, 70);
        // Capacity equal to threshold should NOT be included (strictly greater)
        assertEquals(1, filtered.size());
        assertEquals("AC Chair", filtered.get(0).getName());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Sleeper", 50),
                new UseCase8TrainConsistMgmt.Bogie("AC Chair", 60)
        );
        List<UseCase8TrainConsistMgmt.Bogie> filtered = uc8.filterBogiesByCapacity(bogies, 70);
        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72),
                new UseCase8TrainConsistMgmt.Bogie("AC Chair", 75),
                new UseCase8TrainConsistMgmt.Bogie("First Class", 80)
        );
        List<UseCase8TrainConsistMgmt.Bogie> filtered = uc8.filterBogiesByCapacity(bogies, 70);
        assertEquals(3, filtered.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Sleeper", 40),
                new UseCase8TrainConsistMgmt.Bogie("AC Chair", 55)
        );
        List<UseCase8TrainConsistMgmt.Bogie> filtered = uc8.filterBogiesByCapacity(bogies, 60);
        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = Arrays.asList(
                new UseCase8TrainConsistMgmt.Bogie("Sleeper", 100),
                new UseCase8TrainConsistMgmt.Bogie("AC Chair", 80)
        );
        List<UseCase8TrainConsistMgmt.Bogie> filtered = uc8.filterBogiesByCapacity(bogies, 60);
        assertEquals(2, filtered.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = Collections.emptyList();
        List<UseCase8TrainConsistMgmt.Bogie> filtered = uc8.filterBogiesByCapacity(bogies, 60);
        assertTrue(filtered.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmt.Bogie("AC Chair", 65));
        int originalSize = bogies.size();

        uc8.filterBogiesByCapacity(bogies, 60);

        // Original list should remain unchanged
        assertEquals(originalSize, bogies.size());
    }
}