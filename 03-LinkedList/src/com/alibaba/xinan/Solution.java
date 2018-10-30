package com.alibaba.xinan;

/**
 * LeetCode no.203 Question solution
 *
 * @author XinAnzzZ
 * @date 2018/10/26 13:54
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        // 头结点就等于要移除的元素
        while (head != null && head.val == val) {
            ListNode target = head;
            head = head.next;
            target.next = null;
        }

        if (head == null) {
            return null;
        }

        // 非头结点就等于要移除的元素
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                ListNode target = pre.next;
                pre.next = target.next;
                target.next = null;
                continue;
            }
            pre = pre.next;
        }
        return head;
    }

    /**
     * 递归的方式解决这个问题
     */
    public ListNode removeElementsByRecursive(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = removeElementsByRecursive(head.next, val);
        return head.val == val ? head.next : head;
    }
}
