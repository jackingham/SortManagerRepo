package com.sparta.jack.interfaces;

import com.sparta.jack.exceptions.ArrayTooSmallException;

public interface Sorter {

    int[] sortArray(int[] arrayToSort) throws ArrayTooSmallException;
}
