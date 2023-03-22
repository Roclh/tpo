package org.Roclh;

import java.util.Arrays;

public class CountingSort {

    public static int[] sort(int[] arr){
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(0);
        int range = max - min + 1;
        int[] count = new int[range];
        int[] sortedArr = new int[arr.length];

        // Count the occurrences of each element
        for (int j : arr) {
            count[j - min]++;
        }

        // Accumulate the counts to determine the position of each element in the sorted array
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array
        for (int i = arr.length - 1; i >= 0; i--) {
            sortedArr[--count[arr[i] - min]] = arr[i];
        }


        return sortedArr;
    }
}
