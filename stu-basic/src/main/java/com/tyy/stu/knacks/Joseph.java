package com.tyy.stu.knacks;

/**
 * 约瑟夫环
 * X = 总个数
 * Y = 最后剩下的位置
 * X = a + 2^n
 * Y = 2*a +1
 */
public class Joseph {


    public static void main(String[] args) {

        System.out.println(getLastResult(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }


    private static int getLastResult(int[] arr) {

        int length = arr.length;
        int a = 0;
        for (int i = 0; i < length; i++) {
            double pow = Math.pow(2, i);
            if (pow < length) continue;
            if (pow == length) {
                a = length - (int) Math.pow(2, i);
                break;
            }
            if (pow > length) {
                a = length - (int) Math.pow(2, i - 1);
                break;
            }
        }

        return arr[2 * a];
    }


}
