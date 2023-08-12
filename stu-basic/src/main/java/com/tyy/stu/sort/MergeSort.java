package com.tyy.stu.sort;

import java.util.Arrays;

/**
 * 归并排序 :稳定
 * 时间复杂度： 最好情况最坏情况都是 n*log(n)
 * 空间复杂度： O(n)
 */
public class MergeSort {


    public static void main(String[] args) {

        int[] result = sort(SortUtils.getArr(100000));
        System.out.println(Arrays.toString(result));

    }


    /**
     * 将数组进行拆分到最小，然后一步步往上合并
     */
    private static int[] sort(int[] arr) {

        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        if (arr.length <= 2) {
            return merge(left, right);
        }
        return merge(sort(left), sort(right));
    }


    /**
     * 进行归并
     *
     * @param a 已经排序后的数组
     * @param b 已经排序后的数组
     * @return 排序后的新数组
     */
    private static int[] merge(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;


        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) result[k++] = a[i++];
            else result[k++] = b[j++];
        }

        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        return result;

    }


}
