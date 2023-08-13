package com.tyy.stu.leetcode;

import org.junit.jupiter.api.Test;

public class Solution5 {


    public String longestPalindrome(String s) {

        if (s.length() == 1) return s;

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 1; i < s.length(); i++) {
            //todo
        }


        return "";
    }


    @Test
    public void test() {

        longestPalindrome("babad");

    }


}
