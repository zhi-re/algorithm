package com.fouze.practice;

import com.fouze.base.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * @Date 2022/10/11 20:22
 * @Author chenqi
 */
public class Lc24_SwapLinkedListPairs {










    public ListNode swapPairs(ListNode head) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode temp = dump;
        while (temp.next!=null&&temp.next.next!=null){
            ListNode l1 =   temp.next;
            ListNode l2 =   temp.next.next;
            // t - l1 -l2 ->  t -l2 -l1
            temp.next = l2;
            l1.next = l2.next;
            l2.next=l1;

            temp=l1;
        }
        return dump.next;
    }


}
