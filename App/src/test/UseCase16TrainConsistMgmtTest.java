package test;

import main.UseCase16BubbleSort.GoodsBogie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase16TrainConsistMgmtTest {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo()); // should not be assigned
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum"); // fails
        bogie.assignCargo("Grain");     // should succeed

        assertEquals("Grain", bogie.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // We can't directly assert println,
        // but we ensure method completes without crash
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}