package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.ListNode;

/**
 * 重排链表
 * <p>给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>  L0 → L1 → … → Ln - 1 → Ln
 * <p>请将其重新排列后变为：
 * <p>  L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
class Solution143 {

    public static void main(String[] args) {
        Solution143 solution = new Solution143();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.print();
        solution.reorderList(head);
        head.print();
    }

    public void reorderList(ListNode head) {
        // 首先找到链表的中心点，将其分为前后两个链表
        // 然后将后半段链表反转
        // 再前-后链表依次交叉链接

        // 快慢指针寻找中心点 slow
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半段链表 slow
        ListNode cur = slow;
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        // 交叉链接 pre 和 head
        while (pre.next != null) {
            ListNode first = head.next;
            ListNode second = pre.next;
            head.next = pre;
            pre.next = first;
            head = first;
            pre = second;
        }
    }

}

