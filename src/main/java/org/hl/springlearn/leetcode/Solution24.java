package org.hl.springlearn.leetcode;

/**
 * 两两交换链表中的节点
 * <p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
class Solution24 {

    public static void main(String[] args) {
        swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))).print();
        swapPairs(new ListNode(1)).print();
        swapPairs(new ListNode()).print();
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            temp.next.next = swapPairs(temp.next.next);
            head = temp;
        }
        return head;
    }

}