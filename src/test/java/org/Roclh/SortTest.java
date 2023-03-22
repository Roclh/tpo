package org.Roclh;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    @Test
    @DisplayName("Checking only positive values")
    public void checkPositiveSorting(){
        assertAll(
                () -> assertArrayEquals(new int[]{3, 5, 7, 23, 32, 32}, CountingSort.sort(new int[]{32, 7, 5, 23, 3, 32})),
                () -> assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9,10}, CountingSort.sort(new int[]{1, 2, 9, 5, 4, 8, 7, 3, 6, 10})),
                () -> assertArrayEquals(new int[]{2,3,3,4,6,7,8,9,10,11,12,13,13,15,16,17,18,19,19,20,20,21,22,23,23,23,23,27,28,28},
                        CountingSort.sort(new int[]{17, 18, 2,13,19,23, 10, 23, 28, 4, 23, 11, 16, 3, 27, 22, 20,3, 13, 19,8, 21, 12, 9, 20, 28 ,7, 6 ,23, 15}))
        );
    }

    @Test
    @DisplayName("Checking only negative values")
    public void checkNegativeSorting(){
        assertAll(
                () -> assertArrayEquals(new int[]{-200, -100, -75, -50, -20}, CountingSort.sort(new int[]{ -75,-100, -50, -200, -20})),
                () -> assertArrayEquals(new int[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1}, CountingSort.sort(new int[]{-1, -2, -3, -4, -5, -6, -7, -8, -9, -10})),
                () -> assertArrayEquals(new int[]{-300, -199, -197, -196, -43, -1}, CountingSort.sort(new int[]{-300, -199, -197, -196, -43, -1}))
        );
    }

    @Test
    @DisplayName("Checking both")
    public void checkHybridSorting(){
        assertAll(
                () -> assertArrayEquals(new int[]{-1000, -200, 0, 200, 1000}, CountingSort.sort(new int[]{0, 1000, 200, -200, -1000})),
                () -> assertArrayEquals(new int[]{-5,-4,-3,-2,-1,0,1,2,3,4,5}, CountingSort.sort(new int[]{5,4,3,2,1,0,-1,-2,-3,-4,-5}))
        );
    }

    @Test
    @DisplayName("Check zeroes")
    public void checkZeroes(){
        assertArrayEquals(new int[]{0, 0, 0, 0, 0}, CountingSort.sort(new int[]{0, 0, 0, 0, 0}));
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Check empty")
    public void checkEmpty(int[] array){
        assertArrayEquals(array, CountingSort.sort(new int[]{}));
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Check null")
    public void checkNull(int[] array){
        assertThrows(NullPointerException.class, ()-> CountingSort.sort(null));
    }

}
