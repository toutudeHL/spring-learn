package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 填充每个节点的下一个右侧节点指针 II
 * <p>给定一个二叉树：
 * <p><code>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * </code>
 * <p>填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>初始状态下，所有 next 指针都被设置为 NULL。
 */
class Solution117 {

    List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) {
        Solution117 solution = new Solution117();
        Node root = new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null);
        System.out.println(solution.connect(root));
        System.out.println(solution.connectBfs(root));
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 通过完全二叉树（116）的层序链接在此处比较复杂，故使用dfs层序遍历后再链接
        levelSearch(root, 1);
        for (List<Node> levelList : list) {
            if (levelList != null && levelList.size() > 1) {
                int index = 0;
                while (index < levelList.size() - 1) {
                    levelList.get(index).next = levelList.get(index + 1);
                    index++;
                }
            }
        }
        return root;
    }

    private void levelSearch(Node root, int level) {
        if (root == null) {
            return;
        }
        if (list.size() < level) {
            list.add(new ArrayList<>());
        }
        list.get(level - 1).add(root);
        if (root.left != null) {

            levelSearch(root.left, level + 1);
        }
        if (root.right != null) {

            levelSearch(root.right, level + 1);
        }
    }

    public Node connectBfs(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Node> levelList = list;
            list = new ArrayList<>();
            for (int i = 0; i < levelList.size(); i++) {
                Node node = levelList.get(i);
                if (i > 0) {
                    levelList.get(i - 1).next = node;
                }
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
        }
        return root;
    }

}