package com.tyy.stu.leetcode;

import org.junit.jupiter.api.Test;

public class Solution459 {




    @Test
    public void test(){
        System.out.println(repeatedSubstringPattern("abcabc"));
        System.out.println(repeatedSubstringPattern("abcdabcd"));
        System.out.println(repeatedSubstringPattern("asdasd"));
        System.out.println(repeatedSubstringPattern("aaas"));
    }


    public boolean repeatedSubstringPattern(String s) {

        // abca abca abca

        for (int i = 2; i <= s.length(); i++) {
            if (s.length() % i == 0) {
                int repeateLength = s.length() / i;
                if (isRepeate(s, i, repeateLength)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isRepeate(String s, int repeateTime, int repeatLength) {
        String originStr = s.substring(0, repeatLength);
        for (int i = 1; i < repeateTime; i++) {
            for (int j = 0; j < repeatLength; j++) {
                if (originStr.charAt(j) != s.charAt(i * repeatLength + j)) {
                    return false;
                }
            }
        }
        return true;
    }


}
