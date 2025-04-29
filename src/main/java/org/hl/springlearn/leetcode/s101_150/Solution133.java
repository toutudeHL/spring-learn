package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 克隆图
 * <p>给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * <p>图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * <p><code>class Node {
 * public int val;
 * public List<Node> neighbors;
 * }</code>
 * <p>测试用例格式：
 * <p>简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * <p>邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * <p>给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 */
class Solution133 {

    Map<Node, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Solution133 solution = new Solution133();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = List.of(node2, node4);
        node2.neighbors = List.of(node1, node3);
        node3.neighbors = List.of(node2, node4);
        node4.neighbors = List.of(node1, node3);
        System.out.println(solution.cloneGraph(node1));
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.put(node, cloneNode);
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

}