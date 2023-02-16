package com.fouze.practice;

import org.junit.Test;
import com.fouze.base.ListNode;

/**
 * 61. 旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * @Date 2022/10/13 15:23
 * @Author chenqi
 */
public class Lc61_RotateRight {


    /**
     * [1,2,3, 4,5], k = 2
     * [4,5,1,2,3]
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        ListNode tail = null;
        int n = 0;
        ListNode temp = head;
        while (temp!=null){
            tail = temp;
            n++;
            temp = temp.next;
        }

        k = k%n;
        k= n-k;
        ListNode p = head;
        for (int i = 0; i < k - 1; i++) {
            p = p.next;
        }
        tail.next = head;
        head = p.next;
        p.next = null;
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
        System.out.println(rotateRight(listNode, 2));

    }
}
