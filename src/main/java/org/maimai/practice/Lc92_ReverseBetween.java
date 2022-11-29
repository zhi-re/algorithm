package org.maimai.practice;

import org.junit.Test;
import org.maimai.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2022/10/18 22:07
 * @Author chenqi
 */
public class Lc92_ReverseBetween {
    /**
     * head = [1,2,3,4,5], left = 2, right = 4
     * [1,4,3,2,5]
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode reverseNode = new ListNode(-1);
        ListNode r = reverseNode;

        ListNode before = new ListNode(-1);
        ListNode b = before;

        ListNode after = new ListNode(-1);
        ListNode a = after;

        int i = 1;
        ListNode h = head;
        while (h != null) {
            if (i < left) {
                System.out.println(i);
                b.next = h;
                b = b.next;
            }
            if (i >= left) {
                h.next = null;
                break;
            }
            h = h.next;
            i++;
        }
        System.out.println(before.next);

        i = 1;
        ListNode h2 = head;
        while (h2 != null) {
            if (i >= left && i <= right) {
                r.next = h2;
                r = r.next;
            }
            h2 = h2.next;
            i++;
        }

        i = 1;
        ListNode h3 = head;
        while (h3 != null) {
            if (i > right) {
                a.next = h3;
                a = a.next;
            }
            h3 = h3.next;
            i++;
        }
        ListNode listNode = reverseListNode(reverseNode.next);
//        ListNode l = listNode;
//        while (l.next!=null){
//            l = l.next;
//        }
//        b.next = listNode;
//
//        l.next  = after;
        System.out.println(before.next);
        System.out.println(listNode);
        System.out.println(after.next);
        return before.next;
    }

    private ListNode reverseListNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverseListNode(head.next);
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
        System.out.println(reverseBetween(listNode, 2, 4));
    }
}
