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
                () -> assertArrayEquals(new int[]{144, 240, 360, 480, 720, 1080}, CountingSort.sort(new int[]{360, 720, 144, 240, 1080, 480}))
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
                () -> assertArrayEquals(new int[]{-1000, -200, 0, 200, 100}, CountingSort.sort(new int[]{0, 100, -100, 200, -200, -1000})),
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
