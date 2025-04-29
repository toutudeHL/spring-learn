package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历 II
 * <p>给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
class Solution107 {

    public static void main(String[] args) {
        Solution107 solution = new Solution107();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(solution.levelOrderBottom(root));
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dps(result, root, 1);
        return result;
    }

    public void dps(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 在list中的索引位置为list大小-层级，呈倒数状态
        int index = result.size() - level;
        if (index == -1) {
            result.add(0, new ArrayList<>());
            index = result.size() - level;
        }
        result.get(index).add(root.val);
        dps(result, root.left, level + 1);
        dps(result, root.right, level + 1);
    }

}