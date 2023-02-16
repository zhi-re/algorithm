package com.fouze.linkedlist;

import org.junit.Test;
import com.fouze.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM15 删除有序链表中重复的元素-I
 * {1,1,2}
 * {1,2}
 *
 * @Date 2022/12/8 16:53
 * @Author chenqi
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            int val = p.val;
            if (list.contains(val)) {
                p = p.next;
                continue;
            }
            list.add(val);
            p = p.next;
        }
        ListNode dummy = new ListNode(-1);
        ListNode dp = dummy;
        if (!list.isEmpty()) {
            for (Integer val : list) {
                ListNode listNode = new ListNode(val);
                dp.next = listNode;
                dp = dp.next;
            }
        }
        return dummy.next;
    }

    @Test
    public void t() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(1);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(deleteDuplicates(listNode));

    }
}
