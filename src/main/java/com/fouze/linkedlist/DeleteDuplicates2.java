package com.fouze.linkedlist;

import com.fouze.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM16 删除有序链表中重复的元素-II
 * {1,2,2}
 * {1}
 *
 * @Date 2022/12/8 19:16
 * @Author chenqi
 */
public class DeleteDuplicates2 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        List<Integer> contains = new ArrayList<>();
        while (p != null) {
            int val = p.val;
            if (list.contains(val)) {
                contains.add(val);
                p = p.next;
                continue;
            }
            list.add(val);
            p = p.next;
        }
        list.removeAll(contains);
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


}
