package com.sparta.jack;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.interfaces.Sorter;
import com.sparta.jack.sort.SortFactory;
import com.sparta.jack.utilities.SortTypes;
import org.junit.jupiter.api.*;
import java.util.Random;
import com.sparta.jack.utilities.Timer;

public class PerformanceTests {
    static Sorter bubbleSorter;
    static Sorter mergeSorter;
    static Sorter binarySorter;

    static int[] testArray1;
    static int[] testArray2;
    static int[] testArray3;


    @BeforeAll
    static void init(){
        SortFactory sortFactory = new SortFactory();
        bubbleSorter = sortFactory.getSorter(SortTypes.BUBBLE);
        mergeSorter = sortFactory.getSorter(SortTypes.MERGE);
        binarySorter = sortFactory.getSorter(SortTypes.BINARY);

        Random generator = new Random();
        int[] testArraySizes = {100,1000,10000};
        int arrayValuesUpperBound = 100;
        testArray1 = new int[testArraySizes[0]];
        testArray2 = new int[testArraySizes[1]];
        testArray3 = new int[testArraySizes[2]];

        for (int i = 0; i < (testArraySizes[0]); i++){
            testArray1[i] = generator.nextInt(arrayValuesUpperBound);
        }
        for (int i = 0; i < testArraySizes[1]; i++){
            testArray2[i] = generator.nextInt(arrayValuesUpperBound);
        }
        for (int i = 0; i < testArraySizes[2]; i++){
            testArray3[i] = generator.nextInt(arrayValuesUpperBound);
        }
    }

    @Test
    @DisplayName("Comparing times for small arrays")
    public void testArray1() throws ArrayTooSmallException {
        Timer.startTimer();
        bubbleSorter.sortArray(testArray1);
        double bubbleSortTime = Timer.stopTimerAndGetTime();

        Timer.startTimer();
        mergeSorter.sortArray(testArray1);
        double mergeSortTime = Timer.stopTimerAndGetTime();

        Timer.startTimer();
        binarySorter.sortArray(testArray1);
        double binarySortTime = Timer.stopTimerAndGetTime();

        Main.logger.info("Bubble sort time (small):" +bubbleSortTime);
        Main.logger.info("Merge sort time (small):" +mergeSortTime);
        Main.logger.info("Binary sort time (small):" +binarySortTime);
    }

    @Test
    @DisplayName("Comparing times for medium arrays")
    public void testArray2() throws ArrayTooSmallException {
        Timer.startTimer();
        bubbleSorter.sortArray(testArray2);
        double bubbleSortTime = Timer.stopTimerAndGetTime();

        Timer.startTimer();
        mergeSorter.sortArray(testArray2);
        double mergeSortTime = Timer.stopTimerAndGetTime();

        Timer.startTimer();
        binarySorter.sortArray(testArray2);
        double binarySortTime = Timer.stopTimerAndGetTime();

        Main.logger.info("Bubble sort time (medium):" +bubbleSortTime);
        Main.logger.info("Merge sort time (medium):" +mergeSortTime);
        Main.logger.info("Binary sort time (medium):" +binarySortTime);
    }

    @Test
    @DisplayName("Comparing times for large arrays")
    public void testArray3() throws ArrayTooSmallException {
        Timer.startTimer();
        bubbleSorter.sortArray(testArray3);
        double bubbleSortTime = Timer.stopTimerAndGetTime();

        Timer.startTimer();
        mergeSorter.sortArray(testArray3);
        double mergeSortTime = Timer.stopTimerAndGetTime();

        Timer.startTimer();
        binarySorter.sortArray(testArray3);
        double binarySortTime = Timer.stopTimerAndGetTime();

        Main.logger.info("Bubble sort time (large):" +bubbleSortTime);
        Main.logger.info("Merge sort time: (large)" +mergeSortTime);
        Main.logger.info("Binary sort time: (large)" +binarySortTime);
    }
}
