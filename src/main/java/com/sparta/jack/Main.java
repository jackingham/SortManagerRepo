package com.sparta.jack;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.exceptions.DuplicateNodeException;
import com.sparta.jack.sort.SortFactory;
import com.sparta.jack.utilities.Printer;
import com.sparta.jack.utilities.SortTypes;
import com.sparta.jack.utilities.Timer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.util.Random;
import com.sparta.jack.interfaces.Sorter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {

    	int[] array = {1,5,78,4,3,54,67,334,5456,576,76,8798,4657,867,7,45,4576,78356,85768}; //hardcoded for user to fill in
		Printer.printMessage("Inital unsorted array: "+Arrays.toString(array));



		try{
			SortFactory sortFactory = new SortFactory();


			Sorter bubbleSort = sortFactory.getSorter(SortTypes.BUBBLE);
			Printer.printMessage("Starting bubble sort");
			Timer.startTimer();
			int[] bubbleSortedArray = bubbleSort.sortArray(array);
			double bubbleSortTime = Timer.stopTimerAndGetTime();
			Printer.printMessage("Time taken"+bubbleSortTime+" Seconds");
			Printer.printMessage("Result"+Arrays.toString(bubbleSortedArray));

			Sorter mergeSort = sortFactory.getSorter(SortTypes.MERGE);
			Printer.printMessage("Starting merge sort");
			Timer.startTimer();
			int[] mergeSortedArray = mergeSort.sortArray(array);
			double mergeSortTime = Timer.stopTimerAndGetTime();
			Printer.printMessage("Time taken"+mergeSortTime+" Seconds");
			Printer.printMessage("Result"+Arrays.toString(mergeSortedArray));

			Sorter binarySort = sortFactory.getSorter(SortTypes.BINARY);
			Printer.printMessage("Starting binary sort");
			Timer.startTimer();
			int[] binarySortedArray = bubbleSort.sortArray(array);
			double binarySortTime = Timer.stopTimerAndGetTime();
			Printer.printMessage("Time taken"+binarySortTime+" Seconds");
			Printer.printMessage("Result"+Arrays.toString(binarySortedArray));



		} catch(ArrayTooSmallException e) {
			logger.error(e.getMessage(), e);
		} catch (NullPointerException e) {
			logger.fatal(e.getMessage(), e);
		} catch (DuplicateNodeException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }
}
