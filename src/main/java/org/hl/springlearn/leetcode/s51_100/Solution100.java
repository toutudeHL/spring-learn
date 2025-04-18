package org.hl.springlearn.leetcode.s51_100;

import org.hl.springlearn.leetcode.TreeNode;

/**
 * 相同的树
 * <p>给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
class Solution100 {

    public static void main(String[] args) {
        Solution100 Solution100 = new Solution100();
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(Solution100.isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null || q == null) || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}