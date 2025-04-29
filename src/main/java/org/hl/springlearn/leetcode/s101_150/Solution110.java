package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

/**
 * 平衡二叉树
 * <p>给定一个二叉树，判断它是否是 平衡二叉树
 * <p>平衡二叉树 是指该树所有节点的左右子树的高度相差不超过 1。
 */
class Solution110 {

    public static void main(String[] args) {
        Solution110 solution = new Solution110();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftLevel = dps(root.left);
        int rightLevel = dps(root.right);
        if (Math.abs(leftLevel - rightLevel) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int dps(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(dps(root.left), dps(root.right)) + 1;
    }

    public boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        // 剪枝，某个子节点不满足则整体都不满足为平衡二叉树
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        // 剪枝
        if (right == -1) {
            return -1;
        }
        // 高度差小于 2 代表是平衡二叉树，返回当前节点的深度；否则返回 -1 代表不为平衡二叉树
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

}