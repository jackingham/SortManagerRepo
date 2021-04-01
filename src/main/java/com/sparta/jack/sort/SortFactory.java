package com.sparta.jack.sort;

import com.sparta.jack.interfaces.Sorter;
import com.sparta.jack.utilities.SortTypes;

public class SortFactory {

    public Sorter getSorter(SortTypes sortType) {

        Sorter sorter = null;
        switch (sortType) {
            case BUBBLE:
                sorter = BubbleSort.getInstance();
                break;
            case MERGE:
                sorter = MergeSort.getInstance();
                break;
            case BINARY:
                //sorter = BinarySort.getInstance();
                break;
            default:
                sorter = null;
                break;
        }
        return sorter;
    }
}







