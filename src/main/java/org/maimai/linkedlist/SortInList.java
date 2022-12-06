package org.maimai.linkedlist;

import org.junit.Test;
import org.maimai.base.ListNode;

/**
 * BM12 单链表的排序
 * 给定一个节点数为n的无序单链表，对其按升序排序。
 * <p>
 * 数据范围：0 < n ≤ 100000
 * 要求：空间复杂度 O(n)，时间复杂度 O(nlogn)
 *
 * @Date 2022/12/5 22:26
 * @Author chenqi
 */
public class SortInList {

    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 快慢指针找到中点
        ListNode fast = head;
        ListNode slow = head;
        // 1 2 3 4 5
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 4 5
        ListNode right = slow.next;
        // head =  1 2 3
        slow.next = null;
        System.out.println("head:" + head);
        System.out.println("right:" + right);

        ListNode leftNode = sortInList(head);
        ListNode rightNode = sortInList(right);

        ListNode dummy = new ListNode(-1);
        ListNode dummyTemp = dummy;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                dummyTemp.next = leftNode;
                leftNode = leftNode.next;
            } else {
                dummyTemp.next = rightNode;
                rightNode = rightNode.next;
            }
            dummyTemp = dummyTemp.next;
        }
        if (leftNode != null)
            dummyTemp.next = leftNode;
        if (rightNode != null)
            dummyTemp.next = rightNode;
        return dummy.next;
    }

    @Test
    public void t() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(sortInList(listNode));

    }


}
