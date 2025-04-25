package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和 II
 * <p>给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>叶子节点 是指没有子节点的节点。
 */
class Solution113 {

    public static void main(String[] args) {
        Solution113 Solution = new Solution113();
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(5))));
        System.out.println(Solution.pathSum(root, 1));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        backTrack(result, root, targetSum, new ArrayList<>());
        return result;
    }

    public void backTrack(List<List<Integer>> result, TreeNode root, int targetSum, List<Integer> temp) {
        if (root != null && root.left == null && root.right == null && targetSum - root.val == 0) {
            List<Integer> ans = new ArrayList<>(temp);
            ans.add(root.val);
            result.add(ans);
            return;
        }
        if (root == null) {
            return;
        }
        int newTargetSum = targetSum - root.val;
        temp.add(root.val);
        backTrack(result, root.left, newTargetSum, temp);
        backTrack(result, root.right, newTargetSum, temp);
        temp.remove(temp.size() - 1);
    }

}