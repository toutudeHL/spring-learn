package org.hl.springlearn.leetcode.s1_50;

/**
 * 两数相加
 * <p>给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * <p>输入：l1 = [2,4,3], l2 = [5,6,4]
 * <p>输出：[7,0,8]
 * <p>解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * <p>输入：l1 = [0], l2 = [0]
 * <p>输出：[0]
 * <p>
 * 示例 3：
 * <p>输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * <p>输出：[8,9,9,9,0,0,0,1]
 * <p>
 * 提示：
 * <p>每个链表中的节点数在范围 [1, 100] 内
 * <p>0 <= Node.val <= 9
 * <p>题目数据保证列表表示的数字不含前导零
 */
class Solution2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode result = new ListNode();
        ListNode current = result;
        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(sum % 10);
            current = current.next;
            sum /= 10;
        }
        return result.next;
    }

    /**
     * Definition for singly-linked list.
     */
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
    }
}