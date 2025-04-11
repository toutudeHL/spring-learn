package org.hl.springlearn.leetcode.s51_100;

import org.hl.springlearn.leetcode.ListNode;

/**
 * 分隔链表
 * <p>给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>你应当 保留 两个分区中每个节点的初始相对位置。
 */
class Solution86 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        partition(listNode, 3).print();
    }

    public static ListNode partition(ListNode head, int x) {
        // 拼接链表
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode two = new ListNode(0);
        ListNode twoTemp = two;
        while (head != null) {
            if (head.val < x) {
                temp.next = new ListNode(head.val);
                temp = temp.next;
            } else {
                twoTemp.next = new ListNode(head.val);
                twoTemp = twoTemp.next;
            }
            head = head.next;
        }
        temp.next = two.next;
        return result.next;
    }

}