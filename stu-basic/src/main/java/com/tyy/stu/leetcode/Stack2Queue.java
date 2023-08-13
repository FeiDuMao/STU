package com.tyy.stu.leetcode;


import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 用两个栈实现一个队列: 将元素在两个栈之间来回倒
 */
public class Stack2Queue {


    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();


    public Integer get() {

        if (a.isEmpty()) return null;
        while (!a.isEmpty()) b.push(a.pop());
        Integer result = b.pop();
        while (!b.isEmpty()) a.push(b.pop());
        return result;
    }

    public Integer put(Integer item) {
        a.push(item);
        return item;
    }


    @Test
    public void test() {

        Stack2Queue queue = new Stack2Queue();
        queue.put(1);
        System.out.println(queue.get());
        queue.put(2);
        System.out.println(queue.get());
        queue.put(3);
        queue.put(4);

        System.out.println(queue.get());
        System.out.println(queue.get());


    }

}
