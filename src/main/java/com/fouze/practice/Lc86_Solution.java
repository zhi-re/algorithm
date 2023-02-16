package com.fouze.practice;

import org.junit.Test;
import com.fouze.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 *
 * @Date 2022/10/18 21:34
 * @Author chenqi
 */
public class Lc86_Solution {
    // [1,4,3,2,5,2], x = 3
    // [1,2,2,4,3,5]
    public ListNode partition(ListNode head, int x) {
        ListNode listNode = new ListNode(-1);
        ListNode temp = listNode;
        List<Integer> before = new ArrayList<>();
        List<Integer> after = new ArrayList<>();
        while (head != null) {
            if (head.val < x) {
                before.add(head.val);
            } else {
                after.add(head.val);
            }
            head = head.next;
        }
        System.out.println(before);
        System.out.println(after);
        if (before.size() != 0) {
            for (Integer val : before) {
                ListNode l1 = new ListNode(val);
                temp.next = l1;
                temp = temp.next;
            }
        }
        if (after.size() != 0) {
            for (Integer val : after) {
                ListNode l1 = new ListNode(val);
                temp.next = l1;
                temp = temp.next;
            }
        }
        return listNode.next;
    }

    @Test
    public void t() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(partition(listNode, 3));
    }
}
