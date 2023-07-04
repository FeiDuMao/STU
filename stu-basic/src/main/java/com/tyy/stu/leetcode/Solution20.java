package com.tyy.stu.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution20 {


    @Test
    public void test() {
        System.out.println(isValid("()"));

    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            }
        }
        return stack.isEmpty();

    }

}
