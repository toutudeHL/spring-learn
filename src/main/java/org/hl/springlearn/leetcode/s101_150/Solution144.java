package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * <p>给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
class Solution144 {

    public static void main(String[] args) {
        Solution144 solution = new Solution144();
        TreeNode root = new TreeNode(1);
        System.out.println(solution.preorderTraversal(root));
        System.out.println(solution.preorderTraversal1(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) {
            st.push(root);
        }
        while (!st.empty()) {
            TreeNode node = st.peek();
            // 将该节点弹出，避免重复操作
            st.pop();
            if (node != null) {
                if (node.right != null) {
                    // 添加右节点（空节点不入栈）
                    st.push(node.right);
                }
                if (node.left != null) {
                    // 添加左节点（空节点不入栈）
                    st.push(node.left);
                }
                // 添加中节点
                st.push(node);
                // 中节点访问过，但是还没有处理，加入空节点做为标记。
                st.push(null);
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                // 重新取出栈中元素
                node = st.peek();
                st.pop();
                // 加入到结果集
                result.add(node.val);
            }
        }
        return result;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preSearch(result, root);
        return result;
    }

    public void preSearch(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            preSearch(result, root.left);
        }
        if (root.right != null) {
            preSearch(result, root.right);
        }
    }

}

