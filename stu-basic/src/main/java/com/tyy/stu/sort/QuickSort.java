package com.tyy.stu.sort;


import static com.tyy.stu.sort.SortUtils.swap;

/**
 * 快速排序
 * 时间复杂度： 最好情况： n*log(n); 最坏情况：n^2
 * 空间复杂度： log(n)
 */
public class QuickSort {


    public static void main(String[] args) {

        int[] arr = new int[]{6, 2, 4, 9, 5, 7, 3, 8, 1};


    }


    private int[] sort(int[] arr, int start, int end) {


        int mid = arr[start];//本轮排序的基准，比它小的放到左边，大的放到右边
        start++;

        while (start <= end) {
            if (arr[start] >= mid) {
                swap(arr, start, end);

            }

        }


        return arr;
    }


}
