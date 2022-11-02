package org.maimai.practice;

import org.junit.Test;
import org.maimai.base.ListNode;

/**
 * 链表重新排序
 *
 * @Date 2022/11/2 14:03
 * @Author chenqi
 */
public class Lc143_ReorderList {

    /**
     * 1 2 3
     * 5 4
     * ->
     * 1 5 2 4 3
     * <p>
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode middle = slow;
        ListNode reverMiddleListNode = reverListNode(middle.next);
        middle.next = null;
        ListNode l1 = head;
        ListNode l2 = reverMiddleListNode;

//        while (l1 != null) {
//            l1.next = l2;
//            l1 = l1.next;
//            l2.next = l1;
//            l2 = l2.next;
//        }

        while (l1 != null && l2 != null) {
            ListNode l1_tmp = l1.next;
            ListNode l2_tmp = l2.next;
            l1.next = l2;
            l1 = l1_tmp;
            l2.next = l1;
            l2 = l2_tmp;
        }

    }

    private ListNode reverListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverListNode(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    @Test
    public void t() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        reorderList(listNode);

    }
}
