package com.sparta.jack;

import com.sparta.jack.exceptions.ArrayTooSmallException;
import com.sparta.jack.sort.BubbleSort;
import com.sparta.jack.sort.MergeSort;
import com.sparta.jack.utilities.Printer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Main {
	public static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
	    int[] array = {1,7,3,45,66,6,4,3,34,5,67,7,754,345};
		try{
			//int[] bubbleSort = new BubbleSort().sortArray(array);
			int[] mergeSort = new MergeSort().sortArray(array);
	    	//Printer.printMessage(Arrays.toString(bubbleSort));
			Printer.printMessage(Arrays.toString(mergeSort));


		} catch(ArrayTooSmallException e) {
	    	logger.error(e.getMessage(), e);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }
}
