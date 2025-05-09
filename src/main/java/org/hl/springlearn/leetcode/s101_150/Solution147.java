package org.hl.springlearn.leetcode.s101_150;

import org.hl.springlearn.leetcode.ListNode;

/**
 * 对链表进行插入排序
 * <p>给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * <p>插入排序 算法的步骤:
 * <p>  1.插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * <p>  2.每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * <p>  3.重复直到所有输入数据插入完为止。
 */
class Solution147 {

    public static void main(String[] args) {
        Solution147 solution = new Solution147();
        ListNode root = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(3)))));
        solution.insertionSortList(root).print();
    }

    public ListNode insertionSortList(ListNode head) {
        // 创建一个新的链表用于迭代插入已有的元素
        ListNode result = null;
        // 定义新链表中的头尾，表示最大最小，方便后续比较
        ListNode min = null, max = null;
        // 依次将原有链表中的元素插入新的链表中，并放置在合适的位置
        while (head != null) {
            // 当前节点取出，并断开后续节点
            ListNode cur = head;
            head = head.next;
            cur.next = null;
            // 初始化新的链表
            if (result == null) {
                result = cur;
                min = cur;
                max = cur;
                // 初始化完成后继续下一个节点插入
                continue;
            }
            // 比较节点并插入
            if (cur.val <= min.val) {
                // 如果元素比头小，则头插
                cur.next = result;
                result = cur;
                // 更新最小值
                min = cur;
            } else if (cur.val >= max.val) {
                // 如果元素比尾大，则尾插
                max.next = cur;
                // 更新最大值
                max = cur;
            } else {
                // 表示元素在新的链表中间，循环找到位置后插入
                // 之前已经保证过头插和尾插，因此此处肯定会有next节点，不需要额外处理
                ListNode temp = result;
                while (temp.next != null) {
                    if (cur.val >= temp.val && cur.val < temp.next.val) {
                        cur.next = temp.next;
                        temp.next = cur;
                        // 节点插入正确的位置后跳出循环
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
        return result;
    }

}

