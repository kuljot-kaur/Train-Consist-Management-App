package test;

import main.UseCase16BubbleSort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase16TrainConsistMgmtTest {

    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        UseCase16BubbleSort.bubbleSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        UseCase16BubbleSort.bubbleSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        UseCase16BubbleSort.bubbleSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] arr = {50};
        int[] expected = {50};

        UseCase16BubbleSort.bubbleSort(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        int[] expected = {40, 40, 40};

        UseCase16BubbleSort.bubbleSort(arr);

        assertArrayEquals(expected, arr);
    }
}