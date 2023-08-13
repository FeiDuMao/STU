package com.tyy.stu.sort;


/**
 * 选择排序： 优点：简单直接
 * 时间复杂度： 最好最坏情况下都是 n^2
 * 空间复杂度： O(1)
 */
public class ChoseSort implements ArraySort {


    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) swap(arr, i, j);
            }
        }
        return arr;
    }
}
