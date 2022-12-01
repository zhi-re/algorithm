package org.maimai.linkedlist;

import org.junit.Test;
import org.maimai.base.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * BM3 链表中的节点每k个一组翻转
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * <p>
 * 数据范围： 2000 0≤n≤2000，链表中每个元素都满足  10000≤val≤1000
 * 要求空间复杂度 O(1)，时间复杂度 O(n)
 * 例如：
 * 给定的链表是 1→2→3→4→5
 * 对于 k = 2 , 你应该返回 2→1→4→3→5
 * 对于 k = 3 , 你应该返回 3→2→1→4→5
 *
 * @Date 2022/11/30 23:39
 * @Author chenqi
 */
public class ReverseKGroup {

    // 基于栈
    public ListNode reverseKGroup(ListNode head, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListNode dummy = new ListNode(-1);
        ListNode dummyTemp = dummy;
        ListNode p = head;

        List<Integer> list = new ArrayList<>();
        while (p != null) {
            linkedList.addFirst(p.val);
            if (linkedList.size() == k) {
                while (!linkedList.isEmpty()) {
                    Integer pop = linkedList.pop();
                    list.add(pop);
                }
            }
            p = p.next;
        }
        while (!linkedList.isEmpty() && linkedList.size() < k) {
            Integer pop = linkedList.pollLast();
            list.add(pop);
        }
        while (!linkedList.isEmpty() && linkedList.size() == k) {
            Integer pop = linkedList.pop();
            list.add(pop);
        }
        for (Integer integer : list) {
            ListNode listNode = new ListNode(integer);
            dummyTemp.next = listNode;
            dummyTemp = dummyTemp.next;
        }
        return dummy.next;
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
        System.out.println(reverseKGroup(listNode, 6));

    }


}
