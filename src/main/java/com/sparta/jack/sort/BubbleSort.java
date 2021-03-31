package com.sparta.jack.sort;

import com.sparta.jack.Main;
import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.interfaces.Sorter;

public class BubbleSort implements Sorter {

    public int[] sortArray(int[] numberArray) throws ArrayTooSmallException {
        if (numberArray.length == 0 || numberArray.length == 1) {
            throw new ArrayTooSmallException("Array too small!");
        } else {
            int passes = 0, swaps = 0;
            boolean hasSwapOccurred;
            do {
                hasSwapOccurred = false;
                for (int i = 0; i < numberArray.length - 1; i++) {
                    Main.logger.trace("Comparing " + numberArray[i] + " and " + numberArray[i + 1]);
                    if (numberArray[i] > numberArray[i + 1]) {
                        Main.logger.trace(numberArray[i] + " is greater than " + numberArray[i + 1]);
                        int holderVar = numberArray[i];
                        numberArray[i] = numberArray[i + 1];
                        numberArray[i + 1] = holderVar;
                        hasSwapOccurred = true;
                        swaps++;
                    } else {
                        Main.logger.trace(numberArray[i] + " is not greater than " + numberArray[i + 1]);
                    }
                }
                passes++;
            } while (hasSwapOccurred == true);
            Main.logger.info("Passes:" + passes);
            Main.logger.info("Swaps:" + swaps);
            return numberArray;
        }
    }
}

