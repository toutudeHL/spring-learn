package org.hl.springlearn.niuke.listnode;

/**
 * 反转链表
 */
public class Bm1 {

    public static void main(String[] args) {
        Bm1 bm = new Bm1();
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        bm.ReverseList(listNode).print();
    }

    public ListNode ReverseList(ListNode head) {
        ListNode result = new ListNode(0);
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = result.next;
            result.next = temp;
        }

        return result.next;
    }
}


