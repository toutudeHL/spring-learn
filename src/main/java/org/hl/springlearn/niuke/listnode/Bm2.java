package org.hl.springlearn.niuke.listnode;

/**
 * 链表内指定区间反转
 */
public class Bm2 {

    public static void main(String[] args) {
        Bm2 bm = new Bm2();
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(5);
        bm.reverseBetween(listNode, 1, 2).print();
        bm.reverseBetween1(listNode, 1, 2).print();
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int count = 1;

        while (cur != null) {
            if (count < m) {
                // 移动到反转区间的前一个节点
                pre = cur;
                cur = cur.next;
            } else if (count < n) {
                // 反转指定区间的节点
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            } else {
                // 反转完成，退出循环
                break;
            }
            count++;
        }
        return dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        // 用于到达m的前一个节点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // 用于到达n的前一个节点
        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return result.next;
    }
}


