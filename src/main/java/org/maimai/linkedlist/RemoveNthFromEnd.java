package org.maimai.linkedlist;

import org.junit.Test;
import org.maimai.base.ListNode;

/**
 * BM9 删除链表的倒数第n个节点
 * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 * 例如，给出的链表为:1→2→3→4→5, n=2
 * 删除了链表的倒数第 n 个节点之后,链表变为 1→2→3→5.
 *
 * @Date 2022/12/4 21:07
 * @Author chenqi
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        int size = 0;
        while (p != null) {
            p = p.next;
            size++;
        }
        System.out.println(size);
        if (size == n) {
            return head.next;
        }
        // 找到n的前一个结点
        ListNode p2 = head;
        for (int i = 0; i < size - n - 1; i++) {
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return head;
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
        System.out.println(removeNthFromEnd(listNode, 2));

    }
}
