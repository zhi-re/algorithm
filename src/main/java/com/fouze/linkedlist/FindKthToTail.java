package com.fouze.linkedlist;

import com.fouze.base.ListNode;

/**
 * BM8 链表中倒数最后k个结点
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 * 输入：
 * {1,2,3,4,5},2
 * 返回值：
 * {4,5}
 *
 * @Date 2022/12/4 20:37
 * @Author chenqi
 */
public class FindKthToTail {


    public ListNode findKthToTail(ListNode pHead, int k) {
        if (pHead == null) {
            return null;
        }
        ListNode p = pHead;
        int size = 0;
        while (p != null) {
            p = p.next;
            size++;
        }
        System.out.println(size);
        if (k > size) {
            return null;
        }
        ListNode p2 = pHead;
        for (int i = 0; i < size - k; i++) {
            p2 = p2.next;
        }
        System.out.println(p2);
        return p2;
    }

}
