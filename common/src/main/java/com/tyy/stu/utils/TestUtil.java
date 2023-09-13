package com.tyy.stu.utils;

import java.util.Arrays;
import java.util.Random;

public class TestUtil {


    public static int[] getArr(int size) {
        int[] result = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(size);
        }
        System.out.println("generate arr : " + Arrays.toString(result));
        return result;
    }


}
