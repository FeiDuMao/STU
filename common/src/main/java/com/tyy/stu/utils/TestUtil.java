package com.tyy.stu.utils;

import java.util.Arrays;
import java.util.Random;

public class TestUtil {


    /**
     * @param size  数组的大小
     * @param start 最小值
     * @param end   最大值
     * @return 返回给定大小的随机数组
     */
    public static int[] getRandomArr(int size, int start, int end) {
        int[] result = new int[size];
        Random random = new Random();
        int bond = end - start;
        for (int i = 0; i < size; i++) {
            result[i] = start + random.nextInt(bond);
        }
        System.out.println("generate arr : " + Arrays.toString(result));
        return result;
    }


}
