package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树展开为链表
 * <p>给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * <p>展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
class Solution114 {

    List<TreeNode> list = new LinkedList<>();

    public static void main(String[] args) {
        Solution114 Solution = new Solution114();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(5, null, new TreeNode(6)));
        root = new TreeNode(0);
        Solution.flatten(root);
    }

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        dfs(root);
        for (TreeNode node : list) {
            root.left = null;
            root.right = node;
            root = root.right;
        }
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
    }

}