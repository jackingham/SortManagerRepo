package com.sparta.jack;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.interfaces.BinaryTree;
import com.sparta.jack.interfaces.Sorter;
import com.sparta.jack.sort.BinaryTreeSort;
import com.sparta.jack.sort.SortFactory;
import com.sparta.jack.utilities.SortTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionalTests {
    static Sorter bubbleSorter;
    static Sorter mergeSorter;
    static BinaryTree binarySorter;

    @BeforeAll
    static void init() {
        SortFactory sortFactory = new SortFactory();
        bubbleSorter = sortFactory.getSorter(SortTypes.BUBBLE);
        mergeSorter = sortFactory.getSorter(SortTypes.MERGE);
        binarySorter = (BinaryTree) sortFactory.getSorter(SortTypes.BINARY);
    }

    @Test
    @DisplayName(" Tests function of bubble sort")
    public void testBubbleSort() throws NullPointerException, ArrayTooSmallException {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, bubbleSorter.sortArray(new int[]{5, 9, 2, 1, 8, 4, 3, 7, 6}));
    }


    @Test
    @DisplayName(" Tests function of merge sort")
    public void testMergeSort() throws NullPointerException, ArrayTooSmallException {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, mergeSorter.sortArray(new int[]{5, 9, 2, 1, 8, 4, 3, 7, 6}));
    }

}

