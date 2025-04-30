package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.random.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 随机链表的复制
 * <p>给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>返回复制链表的头节点。
 * <p>用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>  val：一个表示 Node.val 的整数。
 * <p>  random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * <p>你的代码 只 接受原链表的头节点 head 作为传入参数。
 */
class Solution138 {

    Map<Node, Node> map = new HashMap<>();

    public static void main(String[] args) {
        Solution138 solution = new Solution138();
        Node head = new Node(1);
        Node node = new Node(2);
        head.next = node;
        head.random = node;
        node.random = node;
        System.out.println(solution.copyRandomList(head));
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node cloneNode = new Node(head.val);
        map.put(head, cloneNode);
        if (head.next != null) {
            cloneNode.next = copyRandomList(head.next);
        }
        if (head.random != null) {
            cloneNode.random = copyRandomList(head.random);
        }
        return cloneNode;
    }

}

