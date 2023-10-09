package com.tyy.stu.leetcode;

import org.junit.jupiter.api.Test;

class Solution7 {
    public int reverse(int x) {

        if (x == 0) return 0;
        boolean navegate = false;
        if (x < 0) {
            navegate = true;
            x = -x;
        }

        StringBuilder str = new StringBuilder(Integer.valueOf(x).toString());
        StringBuilder reversed = str.reverse();
        while (reversed.charAt(0) == '0') {
            reversed.deleteCharAt(0);
        }

        int result = 0;
        try {
            result = Integer.parseInt(reversed.toString());
        } catch (NumberFormatException ignored) {
        }
        return navegate ? -result : result;

    }

    @Test
    public void test() {

        reverse(1534236469);
    }


}