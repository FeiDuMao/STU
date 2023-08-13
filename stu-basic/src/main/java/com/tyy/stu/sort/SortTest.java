package com.tyy.stu.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {


    @Test
    public void test() {

        ArraySort sort = new ChoseSort();
        int[] origin = sort.getArr(20);
        System.out.println("origin : " + Arrays.toString(origin));
        System.out.println("sorted : " + Arrays.toString(sort.sort(origin)));

    }



}
