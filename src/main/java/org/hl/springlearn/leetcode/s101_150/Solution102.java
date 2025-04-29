package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * <p>给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
class Solution102 {

    public static void main(String[] args) {
        Solution102 solution = new Solution102();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(solution.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(result, root, 1);
        return result;
    }

    public void dfs(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (result.size() < level) {
            result.add(new ArrayList<>());
        }

        result.get(level - 1).add(root.val);

        dfs(result, root.left, level + 1);
        dfs(result, root.right, level + 1);
    }

}