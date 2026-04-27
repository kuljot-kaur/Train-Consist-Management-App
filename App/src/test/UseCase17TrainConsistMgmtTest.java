package test;

import main.UseCase17SortBogieNames;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase17TrainConsistMgmtTest {

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        UseCase17SortBogieNames.sortBogieNames(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        UseCase17SortBogieNames.sortBogieNames(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        UseCase17SortBogieNames.sortBogieNames(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        UseCase17SortBogieNames.sortBogieNames(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Sleeper"};
        String[] expected = {"Sleeper"};

        UseCase17SortBogieNames.sortBogieNames(arr);

        assertArrayEquals(expected, arr);
    }
}