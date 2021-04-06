package com.sparta.jack.sort;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.exceptions.DuplicateNodeException;
import com.sparta.jack.interfaces.Sorter;

public class BinarySortInitialiser implements Sorter {

    //Singleton code
    private static BinarySortInitialiser binarySortInstance = new BinarySortInitialiser();
    private BinarySortInitialiser() { }
    public static BinarySortInitialiser getInstance() {
        return binarySortInstance;
    }

    public int[] sortArray(int[] numberArray) throws ArrayTooSmallException, NullPointerException, DuplicateNodeException {
        int lastDuplicate = 0;
        boolean duplicates = false;
        for(int j = 0; j < numberArray.length; j++){
            for(int k = j+1; k < numberArray.length; k++){
                if (numberArray[k] == numberArray[j]){
                    duplicates = true;
                    lastDuplicate = numberArray[k];
                }
            }
        }
        if (numberArray == null) {
            throw new NullPointerException("Array is null!");
        } else if (numberArray.length == 0 || numberArray.length == 1) {
            throw new ArrayTooSmallException("Array too small!");
        } else if (duplicates == true){
            throw new DuplicateNodeException("No duplicates allowed in binary sort: "+lastDuplicate);
        }
        else {
            BinaryTreeSort bt = new BinaryTreeSort();
            bt.addElements(numberArray);
            return bt.getSortedTreeAsc();
        }
    }
}
