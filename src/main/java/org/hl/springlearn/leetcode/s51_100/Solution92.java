package org.hl.springlearn.leetcode.s51_100;

import org.hl.springlearn.leetcode.ListNode;

/**
 * 反转链表 II
 * <p>给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
class Solution92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseBetween(head, 2, 4).print();
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;

        // 移动到 left 位置的前一个节点
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode current = pre.next;
        ListNode mid = null;
        ListNode midTail = current;

        // 使用头插法反转 left 到 right 之间的节点
        // TODO 思路是对的，代码没写出来
        for (int i = 0; i <= right - left; i++) {
            ListNode next = current.next;
            current.next = mid;
            mid = current;
            current = next;
        }

        // 连接反转后的链表
        pre.next = mid;
        midTail.next = current;

        return dummy.next;
    }

}