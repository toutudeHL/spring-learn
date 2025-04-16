package org.hl.springlearn.leetcode.s51_100;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树 II
 * <p>给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 */
class Solution95 {

    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }

    public static List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    static List<TreeNode> dfs(int l, int r) {
        // TODO 二叉树递归回顾
        // 第n层接收到节点数为n-1时返回的所有搜索二叉树，第n个节点只有2个位置可以插入：
        //
        // 节点n作为根节点，那么所有上层二叉树的n-1个节点都比它小，全部是它的左子树。
        // 节点n不是根节点，节点n只能插入上层返回的搜索二叉树的右子树中，原来的右子树变成节点n的左子树。
        if (l > r) {
            return new ArrayList<TreeNode>() {{
                add(null);
            }};
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            List<TreeNode> leftNodeList = dfs(l, i - 1);
            List<TreeNode> rightNodeList = dfs(i + 1, r);
            for (TreeNode leftNode : leftNodeList) {
                for (TreeNode rightNode : rightNodeList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

}