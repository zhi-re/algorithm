package com.fouze.linkedlist;

import com.fouze.base.ListNode;

/**
 * BM1 反转链表
 * 描述
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 * <p>
 * 数据范围： 0≤ n ≤1000
 * 要求：空间复杂度 O(1) ，时间复杂度 O(n) 。
 * <p>
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 *
 * @Date 2022/11/29 21:55
 * @Author chenqi
 */
public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 4 5 null
        ListNode last = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
