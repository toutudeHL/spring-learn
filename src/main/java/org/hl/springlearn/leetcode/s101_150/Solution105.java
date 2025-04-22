package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * <p>给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
class Solution105 {

    Map<Integer, Integer> inMap;
    private int pre = 0;
    private int in = 0;

    public static void main(String[] args) {
        Solution105 Solution = new Solution105();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(Solution.buildTree(preorder, inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        // 将中序数值及索引转为map，后续方便确定索引位置
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // 索引错误，不存在节点，直接返回 null
        if (inStart >= inEnd || preStart >= preEnd) {
            return null;
        }
        // 根据前序第一个确定节点数值，并根据节点数值确定中序下节点的索引
        int rootIndex = inMap.get(preorder[preStart]);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 确定当前左子树下的节点个数，用于后续确定前序数组的位置
        int preLeftNum = rootIndex - inStart;
        // 左子树：中序数组为节点索引左边数组，后序数组开始索引不变，结束索引为开始索引+左子树节点个数
        root.left = buildTree(preorder, preStart + 1, preStart + preLeftNum + 1, inorder, inStart, rootIndex);
        // 右子树：中序数组为节点索引右边数组，后序数组开始索引为开始索引+左子树节点个数（即上一步的结束索引位置），结束索引为结束索引-1
        root.right = buildTree(preorder, preStart + preLeftNum + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        // TODO 回顾
        return buildTree1(preorder, inorder, Integer.MAX_VALUE + 1);
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder, long stop) {
        // 数组为空则返回null
        if (pre == preorder.length) {
            return null;
        }
        // 中序遍历序列数组顺序值等于终止值，则依次后移
        // 表示此节点为空
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        // 按照先序遍历顺序值新建节点
        int val = preorder[pre++];
        TreeNode root = new TreeNode(val);
        // 建立左节点，终止值为当前节点值
        root.left = buildTree1(preorder, inorder, val);
        // 建立右节点，终止值为上一节点值
        root.right = buildTree1(preorder, inorder, stop);
        // 返回当前节点
        return root;
    }

}