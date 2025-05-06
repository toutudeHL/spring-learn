package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.ListNode;

/**
 * 环形链表
 * <p>给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * <p>如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
class Solution141 {

    public static void main(String[] args) {
        Solution141 solution = new Solution141();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;
        System.out.println(solution.hasCycle(head));
        System.out.println(solution.hasCycle1(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (true) {
            if (slow == fast) {
                return true;
            }
            if (slow.next == null) {
                return false;
            }
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
    }

    public boolean hasCycle1(ListNode head) {
        // 简化写法
        ListNode slow = head;
        ListNode fast = head;
        // 只需要判断快指针是否为空即可，因为快指针已经走过了，慢指针不可能为空
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}

