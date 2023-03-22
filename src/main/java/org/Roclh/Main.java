package org.Roclh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Main {
    private static final Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        log.info("Это лаба по тпо, она не должна запускаться, только тестироваться)");
        int[] array =new int[]{3, 5, 7, 23, 32, 32};
        System.out.println(Arrays.toString(CountingSort.sort(array)));
    }
}
