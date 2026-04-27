package test;

import main.UseCase13PerformanceComparison;
import main.UseCase13PerformanceComparison.Bogie;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmtTest {

    private List<Bogie> createTestData() {
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 50));
        bogies.add(new Bogie("AC", 70));
        bogies.add(new Bogie("FirstClass", 80));
        bogies.add(new Bogie("Chair", 40));

        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result =
                UseCase13PerformanceComparison.filterUsingLoop(createTestData());

        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result =
                UseCase13PerformanceComparison.filterUsingStream(createTestData());

        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult =
                UseCase13PerformanceComparison.filterUsingLoop(createTestData());

        List<Bogie> streamResult =
                UseCase13PerformanceComparison.filterUsingStream(createTestData());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createTestData();

        long start = System.nanoTime();
        UseCase13PerformanceComparison.filterUsingLoop(bogies);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Test", i % 100));
        }

        List<Bogie> result =
                UseCase13PerformanceComparison.filterUsingStream(bogies);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}