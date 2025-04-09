package org.hl.springlearn.leetcode;

/**
 * 删除排序链表中的重复元素 II
 * <p>给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
class Solution82 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        deleteDuplicates(listNode).print();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // TODO 链表回顾
        ListNode result = new ListNode(0, head);
        ListNode temp = result;
        while (temp.next != null && temp.next.next != null) {
            int val = temp.next.val;
            if (temp.next.next.val == val) {
                while (temp.next != null && temp.next.val == val) {
                    temp.next = temp.next.next;
                }
            } else {
                temp = temp.next;
            }
        }
        return result.next;
    }

}