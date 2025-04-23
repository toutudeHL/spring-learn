package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

/**
 * 二叉树的最大深度
 * <p>给定一个二叉树 root ，返回其最大深度。
 * <p>二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
class Solution104 {

    public static void main(String[] args) {
        Solution104 Solution = new Solution104();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(Solution.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}