package com.sparta.jack;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.interfaces.BinaryTree;
import com.sparta.jack.sort.BinarySortInitialiser;
import com.sparta.jack.sort.BinaryTreeSort;
import com.sparta.jack.sort.SortFactory;
import com.sparta.jack.utilities.SortTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySortTests {  //n.b the tests for binary tree (sort) are more complex than the others so I placed these in a separate file.

    static BinaryTreeSort bt;

    @BeforeAll
    static void init() {
        bt = new BinaryTreeSort();
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


}

