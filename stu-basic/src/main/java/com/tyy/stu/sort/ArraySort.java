package com.tyy.stu.sort;

import java.util.Random;

public interface ArraySort {

    int[] sort(int[] arr);



    default int[] getArr() {
        return new int[]{6, 2, 4, 9, 5, 7, 3, 8, 1};
    }

    /**
     * @param size 数组的大小
     * @return 返回给定大小的随机数组（0 - size）中的随机数
     */
    default int[] getArr(int size) {
        int[] result = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(size);
        }
        return result;
    }


    default int max(int a, int b) {
        return a - b > 0 ? a : b;
    }

    default int[] swap(int[] arr, int a, int b) {

        if (a < 0 || b < 0 || a > arr.length || b > arr.length) throw new IndexOutOfBoundsException();

        int tmp = arr[b];
        arr[b] = arr[a];
        arr[a] = tmp;

        return arr;
    }


}
