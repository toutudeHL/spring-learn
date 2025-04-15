package org.hl.springlearn.leetcode.s51_100;

import org.hl.springlearn.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * <p>给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
class Solution94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        midSearch(result, root);
        return result;
    }

    public static void midSearch(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            midSearch(result, root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            midSearch(result, root.right);
        }
    }

    // TODO 二叉树遍历-迭代法回顾

    /**
     * 前序遍历-迭代法
     * 前序遍历顺序：中-左-右，入栈顺序：中-右-左
     */
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

    /**
     * 中序遍历-迭代法
     * 中序遍历顺序: 左-中-右 入栈顺序： 左-右
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
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
                // 添加中节点
                st.push(node);
                // 中节点访问过，但是还没有处理，加入空节点做为标记。
                st.push(null);
                if (node.left != null) {
                    // 添加左节点（空节点不入栈）
                    st.push(node.left);
                }
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

    /**
     * 后序遍历-迭代法
     * 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
     */
    public List<Integer> postorderTraversal(TreeNode root) {
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
                // 添加中节点
                st.push(node);
                // 中节点访问过，但是还没有处理，加入空节点做为标记。
                st.push(null);
                if (node.right != null) {
                    // 添加右节点（空节点不入栈）
                    st.push(node.right);
                }
                if (node.left != null) {
                    // 添加左节点（空节点不入栈）
                    st.push(node.left);
                }
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

}