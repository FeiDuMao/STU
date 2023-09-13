package com.tyy.stu.leetcode;

import com.tyy.stu.utils.TestUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution135 {


    public int candy(int[] ratings) {


        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < ratings.length; i++) {

            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            }

        }

        for (int i = ratings.length-1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                right[i - 1] = right[i] + 1;
            }


        }

        int result = 0;
        for (int i = 0; i < ratings.length; i++) {
            result += Math.max(left[i], right[i]);
        }
        return result;
    }


    @Test
    public void test() {
        int[] arr = TestUtil.getArr(4);
        System.err.println(candy(new int[]{1,2,2}));


    }


}