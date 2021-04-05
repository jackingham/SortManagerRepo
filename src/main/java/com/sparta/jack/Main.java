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
		int arraySize = input.nextInt();
    	int[] array = new int[arraySize];
		Random generator = new Random();
    	for (int i = 0; i < arraySize; i++){
    		array[i] = generator.nextInt(10000);
    		Printer.printMessage(Integer.toString(array[i]));
		}



		try{
			SortFactory sortFactory = new SortFactory();
			Sorter bubbleSort = sortFactory.getSorter(SortTypes.BUBBLE);
			int[] bubbleSortedArray = bubbleSort.sortArray(array);

			Sorter mergeSort = sortFactory.getSorter(SortTypes.MERGE);
			int[] mergeSortedArray = mergeSort.sortArray(array);

			Sorter binaryTreeSort = sortFactory.getSorter(SortTypes.BINARY);

			Printer.printMessage(Arrays.toString(mergeSortedArray));

		} catch(ArrayTooSmallException e) {
			logger.error(e.getMessage(), e);
		} catch (NullPointerException e) {
			logger.fatal(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }
}
