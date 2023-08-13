package com.tyy.stu.sort;


/**
 * 快速排序
 * 时间复杂度： 最好情况： n*log(n); 最坏情况：n^2
 * 空间复杂度： log(n)
 */
public class QuickSort implements ArraySort {



    @Override
    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }


    private void quickSort(int[] array, int low, int hight) {
        //if (array.length < 1 || low < 0 || hight >= array.length || low > hight) return null;
        if (low < hight) {
            int privotpos = partition(array, low, hight);
            quickSort(array, low, privotpos - 1);
            quickSort(array, privotpos + 1, hight);
        }

    }


    private int partition(int[] array, int low, int hight) {
        int privot = array[low];
        while (low < hight) {
            while (low < hight && array[hight] >= privot) --hight;
            array[low] = array[hight];
            while (low < hight && array[low] <= privot) ++low;
            array[hight] = array[low];
        }
        array[low] = privot;
        return low;
    }


}
