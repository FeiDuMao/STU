package com.tyy.stu.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {


    @Test
    public void test() {


        System.out.println(lengthOfLongestSubstring("dvdf"));

    }

    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int i = 0;
        int j = 0;

        Map<Character, Integer> map = new HashMap<>();

        // abc bde
        while (j < s.length()) {
            char cur = s.charAt(j);
            if (map.containsKey(cur)) {
                i = Math.max(i, map.get(cur) + 1);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(cur, j++);
        }

        return maxLength;
    }


}
