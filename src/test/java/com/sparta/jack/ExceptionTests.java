package com.sparta.jack;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.interfaces.Sorter;
import com.sparta.jack.sort.SortFactory;
import com.sparta.jack.utilities.SortTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExceptionTests {
    static Sorter bubbleSorter;
    static Sorter mergeSorter;

    @BeforeAll
    static void init(){
        SortFactory sortFactory = new SortFactory();
        bubbleSorter = sortFactory.getSorter(SortTypes.BUBBLE);
        mergeSorter = sortFactory.getSorter(SortTypes.MERGE);
    }

    @Test
    @DisplayName("Testing if bubble sort will reject an empty array")
    public void testEmptyArray_bubble(){
        int[] emptyArray = {};
        Exception e = assertThrows(ArrayTooSmallException.class, () -> {
            bubbleSorter.sortArray(emptyArray);
        });
        String expectedMessage = "Array too small!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing if merge sort will reject an empty array")
    public void testEmptyArray_merge(){
        int[] emptyArray = {};
        Exception e = assertThrows(ArrayTooSmallException.class, () -> {
            mergeSorter.sortArray(emptyArray);
        });
        String expectedMessage = "Array too small!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing if bubble sort will reject an array too short")
    public void testShortArray_bubble(){
        int[] shortArray = {1};
        Exception e = assertThrows(ArrayTooSmallException.class, () -> {
            bubbleSorter.sortArray(shortArray);
        });
        String expectedMessage = "Array too small!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing if bubble sort will reject an array too short")
    public void testShortArray_merge(){
        int[] shortArray = {1};
        Exception e = assertThrows(ArrayTooSmallException.class, () -> {
            mergeSorter.sortArray(shortArray);
        });
        String expectedMessage = "Array too small!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing if bubble sort will reject a null array")
    public void testNullArray_bubble(){
        int[] emptyArray = null;
        Exception e = assertThrows(NullPointerException.class, () -> {
            bubbleSorter.sortArray(emptyArray);
        });
        String expectedMessage = "Array too small!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing if merge sort will reject a null array")
    public void testNullArray_merge(){
        int[] emptyArray = null;
        Exception e = assertThrows(NullPointerException.class, () -> {
            mergeSorter.sortArray(emptyArray);
        });
        String expectedMessage = "Array too small!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }




}
