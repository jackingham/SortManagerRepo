package com.sparta.jack;

import com.sparta.jack.exceptions.ArrayTooSmallException;

import com.sparta.jack.sort.SortFactory;
import com.sparta.jack.utilities.Printer;
import com.sparta.jack.utilities.SortTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;
import com.sparta.jack.interfaces.Sorter;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {

    	Printer.printMessage("Enter how many numbers in array: ");
    	Scanner input= new Scanner(System.in);
		int arraysize = input.nextInt();
    	int[] array = new int[arraysize];
		Random generator = new Random();
    	for (int i = 0; i < arraysize; i++){
    		array[i] = generator.nextInt(1000);
		}

		try{
			SortFactory sortFactory = new SortFactory();

			Sorter bubbleSort = sortFactory.getSorter(SortTypes.BUBBLE);
			long startTime = System.nanoTime();
			int[] bubbleSortedArray = bubbleSort.sortArray(array);
			long endTime = System.nanoTime();
			Printer.printMessage(Long.toString((endTime - startTime)/10000));

			Sorter mergeSort = sortFactory.getSorter(SortTypes.MERGE);
			startTime = System.nanoTime();
			int[] mergeSortedArray = mergeSort.sortArray(array);
			endTime = System.nanoTime();
			Printer.printMessage(Long.toString((endTime - startTime)/10000));


			Printer.printMessage(Arrays.toString(bubbleSortedArray));
			Printer.printMessage(Arrays.toString(mergeSortedArray));

		} catch(ArrayTooSmallException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }
}
