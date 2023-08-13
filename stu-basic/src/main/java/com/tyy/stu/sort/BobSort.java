package com.tyy.stu.sort;


/**
 * 冒泡排序
 * 时间复杂度： 最好情况  O(n) ; 最坏情况 ： O(n^2)
 * 空空间复杂度: O(1)
 */
public class BobSort implements ArraySort {


    /**
     * 依次比较相邻的两个元素，不断地把大的往后移
     */
    public int[] sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }

        return arr;

    }


}
