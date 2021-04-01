package com.sparta.jack;

import com.sparta.jack.interfaces.Sorter;
import com.sparta.jack.sort.SortFactory;
import com.sparta.jack.utilities.SortTypes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FunctionalTests {
    static Sorter bubbleSorter;
    static Sorter mergeSorter;

    @BeforeAll
    static void init() {
        SortFactory sortFactory = new SortFactory();
        bubbleSorter = sortFactory.getSorter(SortTypes.BUBBLE);
        mergeSorter = sortFactory.getSorter(SortTypes.MERGE);
    }

    @Test
    @DisplayName(" Tests function of bubble sort")
    public void testBubbleSort(){};

}
