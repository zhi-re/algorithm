package com.fouze.linkedlist;

import org.junit.Test;
import com.fouze.base.ListNode;

/**
 * BM4 合并两个排序的链表
 * 描述
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}
 *
 * @Date 2022/12/2 23:17
 * @Author chenqi
 */
public class Merge {

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyTemp = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummyTemp.next = l1;
                l1 = l1.next;
            } else {
                dummyTemp.next = l2;
                l2 = l2.next;
            }
            dummyTemp = dummyTemp.next;
        }
        if (l1 != null)
            dummyTemp.next = l1;
        if (l2 != null)
            dummyTemp.next = l2;
        return dummy.next;
    }

    @Test
    public void t() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        System.out.println(merge(listNode, listNode4));

    }


}
