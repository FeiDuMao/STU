package com.tyy.stu.leetcode;

public class Solution198 {


    public int rob(int[] nums) {


        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);


        //dp： 每个长度所能达到的最大值
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + dp[0];

        for (int i = 3; i < nums.length; i++) {
            //状态转移方程 ： 当前最大值为 前面两个中大的那个加上当前数组的元素的值；
            //dp[i]表示 长度为i的时候的最大值
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);

    }


}
