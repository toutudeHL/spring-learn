package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.Node;

/**
 * 填充每个节点的下一个右侧节点指针
 * <p>给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
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
class Solution116 {

    public static void main(String[] args) {
        Solution116 Solution = new Solution116();
        Node root = new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null);
        System.out.println(Solution.connect(root));
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        return connect(root, true);
    }

    private Node connect(Node root, boolean first) {
        // 根据当前层来连接左右子树
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            // 当前层有下节点，则将 当前层的右子树下节点 指向 当前层下节点的左子树
            if (root.next != null) {
                root.right.next = root.next.left;
                // 下节点重复执行， false 为了避免重复执行下一层的连接
                connect(root.next, false);
            }
        }
        // 只有下一层的最左边才重复执行
        if (first) {
            connect(root.left);
        }
        return root;
    }

}