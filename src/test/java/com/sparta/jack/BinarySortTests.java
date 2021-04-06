package com.sparta.jack;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.exceptions.ChildNotFoundException;
import com.sparta.jack.exceptions.DuplicateNodeException;
import com.sparta.jack.interfaces.Sorter;
import com.sparta.jack.sort.BinaryTreeSort;
import com.sparta.jack.sort.SortFactory;
import com.sparta.jack.utilities.SortTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySortTests {  //n.b the tests for binary tree (sort) are more complex than the others so I placed these in a separate file.

    static BinaryTreeSort bt;
    static Sorter binarySorter;

    @BeforeAll
    static void init() {
        SortFactory sortFactory = new SortFactory();
        binarySorter = sortFactory.getSorter(SortTypes.BINARY);

        bt = new BinaryTreeSort(); //allows direct access to methods
        bt.addElements(new int[]{3, 2, 5, 1, 4});
    }

    @Test
    @DisplayName("Tests elements are inserted")
    public void treeContainElementsTest() {
        assertTrue(bt.findElement(1));
        assertTrue(bt.findElement(2));
        assertTrue(bt.findElement(3));
        assertTrue(bt.findElement(4));
        assertTrue(bt.findElement(5));
    }
    @Test
    @DisplayName("Tests previous test isn't just always returning true")
    public void treeDoesntContainTest() {
        assertFalse(bt.findElement(6));
    }

    @Test
    @DisplayName("Tests array is sorted ascending")
    public void binaryTreeSortTestAsc(){
        assertArrayEquals(new int[]{1,2,3,4,5}, bt.getSortedTreeAsc());
    }

    @Test
    @DisplayName("Tests array is sorted descending")
    public void binaryTreeSortTestDesc(){
        assertArrayEquals(new int[]{5,4,3,2,1}, bt.getSortedTreeDesc());
    }

    @Test
    @DisplayName("Testing if binary sort will reject an empty array")
    public void testEmptyArray_binary(){
        int[] emptyArray = {};
        Exception e = assertThrows(ArrayTooSmallException.class, () -> binarySorter.sortArray(emptyArray));
        String expectedMessage = "Array too small!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing if binary sort will reject a small array")
    public void testSmallArray_binary(){
        int[] shortArray = {1};
        Exception e = assertThrows(ArrayTooSmallException.class, () -> binarySorter.sortArray(shortArray));
        String expectedMessage = "Array too small!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing if binary sort will throw exception correctly when missing left child")
    public void testNullLeftChild(){
        Exception e = assertThrows(ChildNotFoundException.class, () -> bt.getLeftChild(1));
        String expectedMessage = "No left child";;
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing if binary sort will throw exception correctly when missing right child")
    public void testNullRightChild(){
        Exception e = assertThrows(ChildNotFoundException.class, () -> bt.getRightChild(1));
        String expectedMessage = "No right child";;
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Testing if binary sort will reject a null array")
    public void testNullArray_binary(){
        int[] emptyArray = null;
        assertThrows(NullPointerException.class, () -> binarySorter.sortArray(emptyArray));
    }

    @Test
    @DisplayName("Testing if binary sort will handle an array with duplicates")
    public void testDuplicateArray_binary(){
        int[] duplicateArray = {1,2,3,4,5,1};
        Exception e = assertThrows(DuplicateNodeException.class, () -> binarySorter.sortArray(duplicateArray));
        String expectedMessage = "No duplicates allowed in binary sort";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }


}

