package org.hl.springlearn.leetcode.s151_200;

import org.hl.springlearn.leetcode.ListNode;

/**
 * 相交链表
 * <p>给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
class Solution160 {

    public static void main(String[] args) {
        Solution160 solution = new Solution160();
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);
        ListNode nums = new ListNode(8);
        headA.next = nums;
        headB.next = nums;
        nums.next = new ListNode(4);
        nums.next.next = new ListNode(5);
        System.out.println(solution.getIntersectionNode(headA, headB).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
            // nodeA = nodeA == null ? headB : nodeA.next;
            // nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

}

