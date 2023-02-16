package com.fouze.linkedlist;

import org.junit.Test;
import com.fouze.base.ListNode;

/**
 * BM2 链表内指定区间反转
 * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
 * 例如：
 * 给出的链表为 1→2→3→4→5→NULL, m=2,n=4
 * 返回   1→4→3→2→5→NULL
 * 数据范围： 链表长度 0 < size \le 10000<size≤1000，0 < m \le n \le size0<m≤n≤size，链表中每个节点的值满足 |val| \le 1000∣val∣≤1000
 * 要求：时间复杂度 O(n)O(n) ，空间复杂度 O(n)O(n)
 * 进阶：时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)
 *
 * @Date 2022/11/30 19:58
 * @Author chenqi
 */
public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        //设置虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        //1.走left-1步到left的前一个节点
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        System.out.println("left的前一个节点pre:" + pre);

        //2.走right-left+1步到right节点
        ListNode rigthNode = pre;
        for (int i = 0; i < n - m + 1; i++) {
            rigthNode = rigthNode.next;
        }
        System.out.println("roght-left+1步到right节点rigthNode:" + rigthNode);

        //3.截取出一个子链表
        ListNode leftNode = pre.next;
        System.out.println("截取出一个子链表leftNode:" + leftNode);
        ListNode cur = rigthNode.next;
        System.out.println("截取出一个子链表cur:" + cur);

        //4.切断链接
        pre.next = null;
        System.out.println("切断链接pre:" + pre);
        rigthNode.next = null;
        System.out.println("切断链接rigthNode:" + rigthNode);

        //5.反转局部链表
        System.out.println("反转局部链表leftNode:" + leftNode);
        reverseLinkedList(leftNode);
        System.out.println("反转局部链表leftNode:" + leftNode);
        System.out.println("反转局部链表rigthNode:" + rigthNode);
        System.out.println("反转局部链表cur:" + cur);

        //6.接回原来的链表
        pre.next = rigthNode;
        leftNode.next = cur;
        return dummyNode.next;
    }

    //反转局部链表
    private void reverseLinkedList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        // 2 3 4
        while (cur != null) {
            //断开链表，要记录后续一个
            ListNode temp = cur.next;
            //当前的next指向前一个
            cur.next = pre;
            //前一个更新为当前
            pre = cur;
            //当前更新为刚刚记录的后一个
            cur = temp;
        }

    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        //加个表头
        ListNode res = new ListNode(-1);
        res.next = head;
        //前序节点
        ListNode pre = res;
        //当前节点
        ListNode cur = head;
        //找到m
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        //从m反转到n
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        //返回去掉表头
        return res.next;
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
        System.out.println(reverseBetween(listNode, 2, 4));
//        System.out.println(reverseBetween2(listNode, 2, 4));

    }


    // 1 2 3 4 5
    public ListNode reverseBetween3(ListNode head, int m, int n) {
        // 设置一个虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // m的前一个结点
        // 1 2 3 4 5
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        // 找到n结点（ n - m + 1）
        // 4 5
        ListNode right = pre;
        for (int i = 0; i < n - m + 1; i++) {
            right = right.next;
        }
        // 开始截取m-n之间的结点
        // 2 3 4 5
        ListNode preNode = pre.next;
        // 5
        ListNode cur = right.next;

        // 开始切断
        pre.next = null;
        right.next = null;

        // 开始反转
        reverList(preNode);

        // 开始拼接
        pre.next = right;
        preNode.next = cur;
        return dummy.next;
    }

    // 反转链表
    private void reverList(ListNode head) {
        // 前1个结点
        ListNode pre = null;
        // 当前的结点
        ListNode cur = head;
        // pre 2 3 4
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }
}
