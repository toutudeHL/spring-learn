package org.hl.springlearn.leetcode.s151_200;

/**
 * 最小栈
 * <p>设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>实现 MinStack 类:
 * <p> MinStack() 初始化堆栈对象。
 * <p> void push(int val) 将元素val推入堆栈。
 * <p> void pop() 删除堆栈顶部的元素。
 * <p> int top() 获取堆栈顶部的元素。
 * <p> int getMin() 获取堆栈中的最小元素。
 */
class Solution155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}

class MinStack {

    private Node head;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    static class Node {

        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }

}

