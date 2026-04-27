package test;

import main.UseCase14InvalidCapacity;
import main.UseCase14InvalidCapacity.PassengerBogie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmtTest {

    @Test
    void testException_ValidCapacityCreation() throws Exception {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 70);

        assertNotNull(bogie);
        assertEquals(70, bogie.getCapacity());
    }

    @Test
    void testException_NegativeCapacityThrowsException() {

        Exception exception = assertThrows(
                Exception.class,
                () -> new PassengerBogie("AC", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {

        Exception exception = assertThrows(
                Exception.class,
                () -> new PassengerBogie("Chair", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ExceptionMessageValidation() {

        Exception exception = assertThrows(
                Exception.class,
                () -> new PassengerBogie("FirstClass", -5)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {

        PassengerBogie bogie = new PassengerBogie("Sleeper", 80);

        assertEquals("Sleeper", bogie.getType());
        assertEquals(80, bogie.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {

        PassengerBogie b1 = new PassengerBogie("Sleeper", 60);
        PassengerBogie b2 = new PassengerBogie("AC", 75);
        PassengerBogie b3 = new PassengerBogie("FirstClass", 100);

        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
    }
}