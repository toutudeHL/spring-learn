package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.ListNode;
import org.hl.springlearn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有序链表转换二叉搜索树
 * <p>给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为 平衡 二叉搜索树。
 */
class Solution109 {

    public static void main(String[] args) {
        Solution109 Solution = new Solution109();
        ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        System.out.println(Solution.sortedListToBST(head));
    }

    public TreeNode sortedListToBST(ListNode head) {
        // 偷懒，将链表数值转换为 List ，然后使用 108 题的方法进行构造
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return sortedListToBST(nums, 0, nums.size() - 1);
    }

    public TreeNode sortedListToBST(List<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 二分直接区分左右子树，左闭右闭区间
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = sortedListToBST(nums, left, mid - 1);
        root.right = sortedListToBST(nums, mid + 1, right);
        return root;
    }

    public TreeNode sortedListToBST1(ListNode head) {
        // 直接对链表进行拆分，通过快慢指针找到链表中间位置
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head.next.next, slow = head.next, pre = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            pre = pre.next;
        }
        TreeNode node = new TreeNode(slow.val);
        ListNode y = slow.next;
        pre.next = null;
        node.left = sortedListToBST1(head);
        node.right = sortedListToBST1(y);
        return node;
    }

}