package org.hl.springlearn.leetcode.s101_150;

import java.util.HashMap;

/**
 * LRU 缓存
 * <p>请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * <p>实现 LRUCache 类：
 * <p>  LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * <p>  int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * <p>  void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * <p>函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 */
class Solution146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 0); // 缓存是 {1=0}
        lRUCache.put(2, 2); // 缓存是 {2=2, 1=0}
        System.out.println(lRUCache.get(1));    // 返回 0 ，缓存更新为 {1=0, 2=2}
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {3=3, 1=0}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)，缓存不更新
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)，缓存不更新
        System.out.println(lRUCache.get(3));    // 返回 3 ，缓存更新为 {3=3, 4=4}
        System.out.println(lRUCache.get(4));    // 返回 4 ，缓存更新为 {4=4, 3=3}
    }

}

class LRUCache {

    private final int capacity;
    private final Node head = new Node(0, 0);
    private HashMap<Integer, Node> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 不存在，直接返回 -1
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 返回之前需要更新其为最新使用
        Node node = cache.get(key);
        changeNode(node);
        return node.val;
    }

    private void changeNode(Node node) {
        if (node.pre != head) {
            // 存在前节点，说明不是最新的，将其更新为最新的节点，也就是头部
            Node pre = node.pre, next = node.next;
            if (next == null) {
                // 尾节点
                pre.next = null;
            } else {
                // 中间节点
                pre.next = next;
                next.pre = pre;
            }
            // 交换节点
            Node temp = head.next;
            if (temp != null) {
                node.next = temp;
                temp.pre = node;
            }
            head.next = node;
            node.pre = head;
        }
    }

    public void put(int key, int value) {
        Node node;
        if (!cache.containsKey(key)) {
            // 不存在，新建节点
            node = new Node(key, value);
            cache.put(key, node);
            // 交换节点
            Node temp = head.next;
            if (temp != null) {
                node.next = temp;
                temp.pre = node;
            }
            head.next = node;
            node.pre = head;
        } else {
            // 存在，取出后更新 value
            node = cache.get(key);
            if (node.val != value) {
                node.val = value;
            }
        }
        // 将新节点更新为头节点
        changeNode(node);
        // 判断数量是否超了，超了的话删除尾节点
        if (cache.size() > capacity) {
            Node tail = head;
            while (tail.next.next != null) {
                tail = tail.next;
            }
            Node delete = tail.next;
            tail.next = null;
            cache.remove(delete.key);
        }
    }

    static class Node {

        private int key, val;
        private Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

