package com.fouze.linkedlist;

import org.junit.Test;
import com.fouze.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * BM14 链表的奇偶重排
 * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 * 输入：
 * {1,4,6,3,7}
 * 返回值：
 * {1,6,7,4,3}
 *
 * @Date 2022/12/6 23:25
 * @Author chenqi
 */
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        List<Integer> ji = new ArrayList<>();
        List<Integer> ou = new ArrayList<>();
        int i = 1;
        ListNode p = head;
        while (p != null) {
            System.out.println(p);
            if (i % 2 == 0) {
                ou.add(p.val);
            } else {
                ji.add(p.val);
            }
            p = p.next;
            i++;
        }
        ListNode listNode = new ListNode(-1);
        ListNode dummy = listNode;
        for (Integer integer : ji) {
            ListNode node = new ListNode(integer);
            dummy.next = node;
            dummy = dummy.next;
        }
        for (Integer integer : ou) {
            ListNode node = new ListNode(integer);
            dummy.next = node;
            dummy = dummy.next;
        }
        return listNode.next;
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
        System.out.println(oddEvenList(listNode));

    }

}
