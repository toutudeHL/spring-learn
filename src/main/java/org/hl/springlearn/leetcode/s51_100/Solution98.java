package org.hl.springlearn.leetcode.s51_100;

import org.hl.springlearn.leetcode.TreeNode;

/**
 * 验证二叉搜索树
 * <p>给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>有效 二叉搜索树定义如下：
 * <p>  节点的左子树只包含 小于 当前节点的数。
 * <p>  节点的右子树只包含 大于 当前节点的数。
 * <p>  所有左子树和右子树自身必须也是二叉搜索树。
 */
class Solution98 {

    public static void main(String[] args) {
        Solution98 solution98 = new Solution98();
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(solution98.isValidBST(root));
    }

    TreeNode max;

    public boolean isValidBST(TreeNode root) {
        // 中序遍历是有序的，所以通过中序遍历来验证
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (max != null && root.val <= max.val) {
            return false;
        }
        // 更新最大值
        max = root;
        return isValidBST(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        // 递归
        return validBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    boolean validBST(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validBST(lower, root.val, root.left) && validBST(root.val, upper, root.right);
    }

}