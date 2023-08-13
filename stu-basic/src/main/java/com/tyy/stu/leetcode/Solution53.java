package com.tyy.stu.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution53 {


    public int maxSubArray(int[] nums) {

        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //dp[i] 表示以nums[i]结尾能达到的最大值,即 dp[i-1] + nums[i] 或者 nums[i]
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        //找到最大值
        return Arrays.stream(dp).max().getAsInt();
    }


    @Test
    public void test() {

        int[] nums2 = new int[]{8, -19, 5, -4, 20};

        System.out.println(maxSubArray(nums2));

    }

}
