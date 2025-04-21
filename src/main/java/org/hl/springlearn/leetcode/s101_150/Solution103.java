package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 * <p>给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
class Solution103 {

    public static void main(String[] args) {
        Solution103 Solution102 = new Solution103();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(Solution102.levelOrder(root));
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

        int index = level - 1;
        if (index % 2 == 0) {
            // 偶数层，从左往右
            result.get(index).add(root.val);
        } else {
            // 奇数层，从右往左
            result.get(index).add(0, root.val);
        }

        dfs(result, root.left, level + 1);
        dfs(result, root.right, level + 1);
    }

}