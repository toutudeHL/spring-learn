package org.hl.springlearn.leetcode.s51_100;

import org.hl.springlearn.leetcode.TreeNode;

/**
 * 恢复二叉搜索树
 * <p>给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 */
class Solution99 {

    TreeNode max, node1, node2;

    public static void main(String[] args) {
        Solution99 Solution99 = new Solution99();
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        Solution99.recoverTree(root);
    }

    public void recoverTree(TreeNode root) {
        midSearch(root);
        if (node1 != null && node2 != null) {
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }

    public void midSearch(TreeNode root) {
        // 中序遍历是有序的，所以通过中序遍历来验证
        if (root == null) {
            return;
        }
        midSearch(root.left);
        if (max != null && root.val <= max.val) {
            // 找到逆序对，如果只有一个逆序对，则代表是相邻的两个节点需要交换，因此两个节点都需要更新
            // 如果有两个逆序对，则代表是第一个逆序对的第一个节点和第二个逆序对的第二个节点需要交换，只更新第二个节点即可
            if (node1 == null) {
                node1 = max;
            }
            node2 = root;
        }
        max = root;
        midSearch(root.right);
    }

}