package test;

import main.UseCase20SearchWithValidation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmtTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {

        String[] arr = {};

        Exception ex = assertThrows(
                IllegalStateException.class,
                () -> UseCase20SearchWithValidation.searchBogie(arr, "BG101")
        );

        assertEquals("No bogies available in the train", ex.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {

        String[] arr = {"BG101","BG205"};

        assertDoesNotThrow(() ->
                UseCase20SearchWithValidation.searchBogie(arr, "BG101")
        );
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {

        String[] arr = {"BG101","BG205","BG309"};

        assertTrue(UseCase20SearchWithValidation.searchBogie(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {

        String[] arr = {"BG101","BG205","BG309"};

        assertFalse(UseCase20SearchWithValidation.searchBogie(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {

        String[] arr = {"BG101"};

        assertTrue(UseCase20SearchWithValidation.searchBogie(arr, "BG101"));
    }
}