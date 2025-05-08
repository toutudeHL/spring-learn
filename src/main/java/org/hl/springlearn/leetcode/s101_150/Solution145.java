package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 * <p>给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
class Solution145 {

    public static void main(String[] args) {
        Solution145 solution = new Solution145();
        TreeNode root = new TreeNode(1);
        System.out.println(solution.postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postSearch(result, root);
        return result;
    }

    public void postSearch(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postSearch(result, root.left);
        }
        if (root.right != null) {
            postSearch(result, root.right);
        }
        result.add(root.val);
    }

}

