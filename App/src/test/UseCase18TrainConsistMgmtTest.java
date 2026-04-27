package test;

import main.UseCase18LinearSearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmtTest {

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(UseCase18LinearSearch.searchBogie(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(UseCase18LinearSearch.searchBogie(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(UseCase18LinearSearch.searchBogie(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(UseCase18LinearSearch.searchBogie(arr, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};

        assertTrue(UseCase18LinearSearch.searchBogie(arr, "BG101"));
    }
}