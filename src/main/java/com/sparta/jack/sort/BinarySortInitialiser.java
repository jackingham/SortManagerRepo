package com.sparta.jack.sort;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.interfaces.Sorter;

public class BinarySortInitialiser implements Sorter {

    //Singleton code
    private static BinarySortInitialiser binarySortInstance = new BinarySortInitialiser();
    private BinarySortInitialiser() { }
    public static BinarySortInitialiser getInstance() {
        return binarySortInstance;
    }

    public int[] sortArray(int[] numberArray) throws ArrayTooSmallException, NullPointerException {
        if (numberArray == null) {
            throw new NullPointerException("Array is null!");
        } else if (numberArray.length == 0 || numberArray.length == 1) {
            throw new ArrayTooSmallException("Array too small!");
        } else {
            BinaryTreeSort bt = new BinaryTreeSort();
            bt.setRootElement(numberArray[0]);
            bt.addElements(numberArray);
            return bt.getSortedTreeAsc();
        }
    }
}
