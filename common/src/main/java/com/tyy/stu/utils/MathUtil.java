package com.tyy.stu.utils;

public class MathUtil {


    /**
     * @param num = 2^n + x
     * @return 返回n的最大值
     */
    public static int getMaxNumOfNum(int num) {

        if (num < 0) throw new IllegalArgumentException("input num is less than 0");
        int result = -1;
        while (num > 0) {
            num = num >> 1;
            result++;
        }
        return result;
    }


}
