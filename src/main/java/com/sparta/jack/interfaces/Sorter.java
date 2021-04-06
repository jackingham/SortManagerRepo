package com.sparta.jack.interfaces;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.exceptions.DuplicateNodeException;

public interface Sorter {

    int[] sortArray(int[] arrayToSort) throws ArrayTooSmallException, DuplicateNodeException;
}
