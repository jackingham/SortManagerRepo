package com.sparta.jack.sort;
import com.sparta.jack.Main;
import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.interfaces.Sorter;

public class MergeSort implements Sorter {

    //singleton code
    private static MergeSort mergeSortInstance = new MergeSort();
    private MergeSort(){}
    public static MergeSort getInstance(){
        return mergeSortInstance;
    }

    public int[] sortArray(int[] numberArray) throws ArrayTooSmallException {
        if (numberArray == null) {
            throw new NullPointerException("Array is null!");
        } else if (numberArray.length == 0 || numberArray.length == 1) {
            throw new ArrayTooSmallException("Array too small!");
        } else {
            merge(numberArray, 0, numberArray.length-1);
        }
    return numberArray;
    }



    private void merge(int[] input, int startIndex, int endIndex) {


        int midpointIndex = (startIndex + endIndex) / 2; //calculates the midpointIndex, as this is integer division it always rounds down which handles decimals
        if (startIndex < endIndex) {
            merge(input, startIndex, midpointIndex);  //first half the the array is split
            merge(input, midpointIndex + 1, endIndex); //second half split, the +1 takes the next index after the midpoint
        }


        int i = 0, first = startIndex, second = midpointIndex + 1;
        int[] tmp = new int[endIndex - startIndex + 1]; //temporary array to store the merged

        while (first <= midpointIndex && second <= endIndex) { // makes sure the boundaries of the two halves are not breached
            if (input[first] < input[second]){ //checks if first item is less than second
                tmp[i] = input[first]; //adds the lowest value from the first half to the sorted array
                first++; //moves onto the next value in the array
            } else {
                tmp[i] = input[second]; //else adds the first value from the second list to the array
                second++; //advances the index to the next in the array
            }
            i++; // advances the index of the temp sorted array
            for (int j: tmp){

            }
        }
        while (first <= midpointIndex) { //advances the array if the end of one half has already been reached
            tmp[i] = input[first];
            i++;
            first++;
        }
        while (second <= endIndex) { //as above for other array
            tmp[i] = input[second];
            i++;
            second++;
        }
        for (int j: tmp){

        }
        i = 0;  //re-uses iterative variable
        while (startIndex <= endIndex) {
            input[startIndex++] = tmp[i++]; //sets the output array to the temp array once all indexes have been looped
        }
    }
}


