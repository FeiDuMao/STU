package com.tyy.stu.leetcode;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode head = new ListNode();
        ListNode tmp = head;

        int carry = 0;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int cur = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            tmp.next = new ListNode(cur);
            tmp = tmp.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) {
            tmp.next = new ListNode(carry);
        }
        return head.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
