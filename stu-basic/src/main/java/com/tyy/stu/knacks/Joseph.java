package com.tyy.stu.knacks;

import org.junit.jupiter.api.Test;

/**
 * 约瑟夫环
 * X = 总个数
 * Y = 最后剩下的位置
 * X = a + 2^n
 * Y = 2*a +1
 */
public class Joseph {


    public static void main(String[] args) {

        System.out.println(findLast(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }


    private static int findLast(int[] arr) {
        int tmp = arr.length;
        int i = 0;
        while ((tmp = tmp >> 1) > 0) i++;
        int index = arr.length - (int)Math.pow(2, i);
        return arr[(2 * index)+1];
    }


    @Test
    public void test() {


        int a = 8;

        int i = 1;
        while ((a = a >> 1) > 0) {
            i++;
        }
        System.out.println(i);


    }

}
