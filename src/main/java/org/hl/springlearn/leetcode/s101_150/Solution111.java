package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

/**
 * 二叉树的最小深度
 * <p>给定一个二叉树，找出其最小深度。
 * <p>最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>说明：叶子节点是指没有子节点的节点。
 */
class Solution111 {

    public static void main(String[] args) {
        Solution111 Solution = new Solution111();
        TreeNode root = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));
        System.out.println(Solution.minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 单节点特殊处理
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 单节点特殊处理
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }

}