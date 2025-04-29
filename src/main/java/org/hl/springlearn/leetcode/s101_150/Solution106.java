package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从中序与后序遍历序列构造二叉树
 * <p>给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
class Solution106 {

    Map<Integer, Integer> inMap;

    public static void main(String[] args) {
        Solution106 solution = new Solution106();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        System.out.println(solution.buildTree(inorder, postorder));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inMap = new HashMap<>();
        // 将中序数值及索引转为map，后续方便确定索引位置
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // 索引错误，不存在节点，直接返回 null
        if (inStart >= inEnd || postStart >= postEnd) {
            return null;
        }
        // 根据后序最后一个确定节点数值，并根据节点数值确定中序下节点的索引
        int rootIndex = inMap.get(postorder[postEnd - 1]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 确定当前左子树下的节点个数，用于后续确定后序数组的位置
        int postLeftNum = rootIndex - inStart;
        // 左子树：中序数组为节点索引左边数组，后序数组开始索引不变，结束索引为开始索引+左子树节点个数
        root.left = buildTree(inorder, inStart, rootIndex, postorder, postStart, postStart + postLeftNum);
        // 右子树：中序数组为节点索引右边数组，后序数组开始索引为开始索引+左子树节点个数（即上一步的结束索引位置），结束索引为结束索引-1
        root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postStart + postLeftNum, postEnd - 1);
        return root;
    }

}