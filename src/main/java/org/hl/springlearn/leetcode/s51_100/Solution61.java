package org.hl.springlearn.leetcode.s51_100;

import org.hl.springlearn.leetcode.ListNode;

/**
 * 旋转链表
 * <p>给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
class Solution61 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        rotateRight(listNode, 2).print();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        // TODO 链表复习
        if (head == null || head.next == null) {
            return head;
        }
        // 循环计算链表长度，并将其首尾相连
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        if (k % length == 0) {
            // 如果 k 是 length 的倍数，那么旋转后的链表和原链表相同，直接返回
            return head;
        }
        temp.next = head;
        temp = head;
        // 找到倒数第 k 个节点的前一个节点，将其断开，返回倒数第 k 个节点
        int index = length - k % length - 1;
        while (index-- > 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

}