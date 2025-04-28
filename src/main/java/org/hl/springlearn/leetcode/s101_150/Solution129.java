package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

/**
 * 求根节点到叶节点数字之和
 * <p>给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * <p>每条从根节点到叶节点的路径都代表一个数字：
 * <p>例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * <p>计算从根节点到叶节点生成的 所有数字之和 。
 * <p>叶节点 是指没有子节点的节点。
 */
class Solution129 {

    public static void main(String[] args) {
        Solution129 Solution = new Solution129();
        TreeNode root = new TreeNode(4,
                new TreeNode(9, new TreeNode(5), new TreeNode(1)),
                new TreeNode(0));
        System.out.println(Solution.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preNum) {
        if (root == null) {
            return 0;
        }
        int nowNum = preNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return nowNum;
        }
        return dfs(root.left, nowNum) + dfs(root.right, nowNum);
    }

}