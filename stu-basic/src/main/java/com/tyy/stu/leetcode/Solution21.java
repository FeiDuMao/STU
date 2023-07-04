package com.tyy.stu.leetcode;

import com.tyy.stu.leetcode.obj.ListNode;
import org.junit.jupiter.api.Test;

public class Solution21 {


    @Test
    public void test() {

        ListNode result = mergeTwoLists(
                new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4)))
        );
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }


    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = new ListNode();
        ListNode tmp = head;

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                tmp.next = list2;
                break;
            }
            if (list2 == null) {
                tmp.next = list1;
                break;
            }

            if (list1.val <= list2.val) {
                tmp.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                tmp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            tmp = tmp.next;
        }

        return head.next;

    }


}
