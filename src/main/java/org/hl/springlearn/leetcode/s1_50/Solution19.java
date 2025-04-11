package org.hl.springlearn.leetcode.s1_50;

import java.util.ArrayList;

/**
 * 删除链表的倒数第 N 个结点
 * <p>给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * <p>输入：head = [1,2,3,4,5], n = 2
 * <p>输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * <p>输入：head = [1], n = 1
 * <p>输出：[]
 * <p>
 * 示例 3：
 * <p>输入：head = [1,2], n = 1
 * <p>输出：[1]
 * <p>
 * 提示：
 * <p>链表中结点的数目为 sz
 * <p>1 <= sz <= 30
 * <p>0 <= Node.val <= 100
 * <p>1 <= n <= sz
 */
class Solution19 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        removeNthFromEnd2(l1, 2).print();
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(0, head);
        ListNode left = result;
        ListNode right = result;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return result.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> listNodes = new ArrayList<>();
        while (head != null) {
            listNodes.add(head.val);
            head = head.next;
        }
        listNodes.remove(listNodes.size() - n);
        ListNode result = new ListNode();
        ListNode current = result;
        for (Integer listNode : listNodes) {
            current.next = new ListNode(listNode);
            current = current.next;
        }

        return result.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        void print() {
            ListNode listNode = this;
            while (listNode != null) {
                System.out.print(listNode.val);
                listNode = listNode.next;
            }
        }
    }
}