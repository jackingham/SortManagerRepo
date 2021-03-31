package com.sparta.jack.sort;

import com.sparta.jack.interfaces.Sorter;
import com.sparta.jack.utilities.SortTypes;

public class SortFactory {

    public Sorter getSorter(SortTypes sortType) {

        Sorter sorter = null;
        switch (sortType) {
            case BUBBLE:
                sorter = new BubbleSort();
                break;
            case MERGE:
                sorter = new MergeSort();
                break;
            case BINARY:
                break;
            default:
                sorter = null;
                break;
        }
        return sorter;
    }
}







