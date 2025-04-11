package org.hl.springlearn.leetcode.s51_100;

import org.hl.springlearn.leetcode.ListNode;

/**
 * 删除排序链表中的重复元素
 * <p>给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
class Solution83 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        deleteDuplicates(listNode).print();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0, head);
        ListNode temp = result;
        while (temp.next != null && temp.next.next != null) {
            if (temp.next.val == temp.next.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return result.next;
    }

}