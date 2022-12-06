package org.maimai.linkedlist;

import org.junit.Test;
import org.maimai.base.ListNode;

import java.util.LinkedList;

/**
 * BM13 判断一个链表是否为回文结构
 * 给定一个链表，请判断该链表是否为回文结构。
 * 回文是指该字符串正序逆序完全一致。
 * 输入：
 * {1,2,2,1}
 * 返回值：
 * true
 * 1->2->2->1
 *
 * @Date 2022/12/6 22:54
 * @Author chenqi
 */
public class IsPail {

    public boolean isPail(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.addFirst(head.val);
            head = head.next;
        }
        while (!list.isEmpty()) {
            if (list.size() > 1) {
                Integer first = list.pollFirst();
                Integer last = list.pollLast();
                if (!first.equals(last)) {
                    return false;
                } else {
                    // 如果链表空了，说明没数据了，直接返回true
                    if (list.isEmpty()) {
                        return true;
                    }
                }
            } else {
                // 如果自剩一个数据了，直接返回true
                return true;
            }
        }
        return false;
    }

    @Test
    public void t() {
        ListNode listNode = new ListNode(-401261);
        ListNode listNode2 = new ListNode(-449050);
        ListNode listNode3 = new ListNode(-456674);
        ListNode listNode4 = new ListNode(-456674);
        ListNode listNode5 = new ListNode(-449050);
        ListNode listNode6 = new ListNode(-401261);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(isPail(listNode));

    }

}
