package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.ListNode;

/**
 * 排序链表
 * <p>给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
class Solution148 {

    public static void main(String[] args) {
        Solution148 solution = new Solution148();
        ListNode root = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(3)))));
        solution.sortList(root).print();
    }

    public ListNode sortList(ListNode head) {
        // 可使用 147 题的插入排序 AC，但是时、空复杂度都超了
        // 归并排序 有递归法和分割法两种思路
        // 递归法，找到中心节点后截断，分别在递归两边链表，最后合并（可以设置一个虚拟节点 0 ，用来简化操作）
        // 分割法，依次按照 1 -> 2 -> 4 ... 的长度进行小范围排序，当范围长度超过链表长度是表示排序完成
        return sort(head);
    }

    public ListNode sort(ListNode head) {
        // 递归终止条件，单个节点直接返回
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针找中心点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 递归两侧节点
        ListNode post = sort(slow.next);
        slow.next = null;
        ListNode pre = sort(head);
        // 合并两侧节点
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (pre != null && post != null) {
            if (pre.val <= post.val) {
                temp.next = pre;
                pre = pre.next;
            } else {
                temp.next = post;
                post = post.next;
            }
            temp = temp.next;
        }
        temp.next = pre != null ? pre : post;

        return result.next;
    }

}

