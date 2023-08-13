package com.tyy.stu.sort;

/**
 * 插入排序
 * 时间复杂度： 最好情况  O(n) ; 最坏情况 ： O(n^2)
 * 空空间复杂度: O(1)
 */
public class InsertSort implements ArraySort {


    @Override
    public int[] sort(int[] arr) {


        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i;

            //将当前元素插到合适的位置
            while (j > 0 && arr[j - 1] > tmp) {
                arr[j] = arr[--j];
            }
            arr[j] = tmp;
        }

        return arr;
    }


}
