package org.Roclh;

public class CountingSort {

    public static int[] sort(int[] array){
        int size = array.length;
        int[] result = new int[size + 1];

        // Находим максимальное значение массива
        int max = array[0];
        for(int i = 1; i < size; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        int[] count = new int[max + 1];

        // Сохраняем количество каждого значения
        for (int j : array) {
            count[j]++;
        }

        // Сохраняем кумулятивное количество элементов
        for (int i = 1; i <= max; i++){
            count[i] += count[i-1];
        }

        // Сортируем
        for (int i = size - 1; i >= 0; i--){
            result[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        return result;
    }
}
