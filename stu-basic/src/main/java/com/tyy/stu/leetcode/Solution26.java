package com.tyy.stu.leetcode;

import com.tyy.stu.leetcode.obj.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Solution26 {


    @Test
    public void test() {

        int result = removeDuplicates(new int[]{1, 1, 2});

    }



    public int removeDuplicates(int[] nums) {
        int[] array = Arrays.stream(nums).distinct().toArray();
        return array.length;

    }




}
