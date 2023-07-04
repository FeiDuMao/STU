package com.tyy.stu.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> tmp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (tmp.containsKey(other)) {
                return new int[]{tmp.get(other), i};
            } else {
                tmp.put(nums[i], i);
            }
        }
        return new int[]{};
    }



}
