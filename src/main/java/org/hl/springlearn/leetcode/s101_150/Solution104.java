package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

/**
 * 二叉树的锯齿形层序遍历
 * <p>给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
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