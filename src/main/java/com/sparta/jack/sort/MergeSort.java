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
        //Main.logger.trace("New midpoint is "+input[midpointIndex]+" at index " + midpointIndex);
        if (startIndex < endIndex) {
            //Main.logger.trace("First array is split into indexes "+startIndex+"-"+midpointIndex);
            merge(input, startIndex, midpointIndex);  //first half the the array is split
            //Main.logger.trace("Second array is split into indexes "+(midpointIndex+1)+"-"+endIndex);
            merge(input, midpointIndex + 1, endIndex); //second half split, the +1 takes the next index after the midpoint
        }


        int i = 0, first = startIndex, second = midpointIndex + 1;
        int[] tmp = new int[endIndex - startIndex + 1]; //temporary array to store the merged

        while (first <= midpointIndex && second <= endIndex) { // makes sure the boundaries of the two halves are not breached
            if (input[first] < input[second]){ //checks if first item is less than second
                //Main.logger.trace(input[first] +" is less than "+input[second]);
                tmp[i] = input[first]; //adds the lowest value from the first half to the sorted array
                //Main.logger.trace("Inserting "+input[first]+" to sorted array");
                first++; //moves onto the next value in the array
            } else {
                //Main.logger.trace(input[second] +" is less than "+input[first]);
                tmp[i] = input[second]; //else adds the first value from the second list to the array
               // Main.logger.trace("Inserting "+input[second]+" to sorted array");
                second++; //advances the index to the next in the array
            }
            i++; // advances the index of the temp sorted array
            //Main.logger.trace("Sorted array so far:");
            for (int j: tmp){
                //Main.logger.trace(j);

            }
        }
        while (first <= midpointIndex) { //advances the array if the end of one half has already been reached
            tmp[i] = input[first];
            //Main.logger.trace("Inserting "+input[first]+" as other half finished");
            i++;
            first++;
        }
        while (second <= endIndex) { //as above for other array
            tmp[i] = input[second];
            //Main.logger.trace("Inserting "+input[second]+" as other half finished");
            i++;
            second++;
        }
        //Main.logger.trace("Sorted half array:");
        for (int j: tmp){
            //Main.logger.trace(j);

        }
        i = 0;  //re-uses iterative variable
        while (startIndex <= endIndex) {
            input[startIndex++] = tmp[i++]; //sets the output array to the temp array once all indexes have been looped
        }
    }
}


