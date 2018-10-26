package com.alibaba.xinan;

/**
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
        if (head == null) {
            return null;
        }

        while (head.val == val) {
            // 头结点就等于要移除的元素
            ListNode target = head;
            head = head.next;
            target.next = null;
        }
        return null;
    }


}
