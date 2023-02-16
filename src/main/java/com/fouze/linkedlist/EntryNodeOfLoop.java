package com.fouze.linkedlist;

import com.fouze.base.ListNode;

import java.util.HashSet;

/**
 * BM7 链表中环的入口结点
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 * <p>
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * @Date 2022/12/3 22:43
 * @Author chenqi
 */
public class EntryNodeOfLoop {

    /**
     * 遍历单链表中的每一个结点，如果当前结点没有出现在设定的集合当中，则将其存入进去，
     * 否则，出现在当前集合当中，则当前结点就是环的入口结点。
     *
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode temp = pHead;
        while (temp != null) {
            if (hashSet.contains(temp)) {
                return temp;
            } else {
                hashSet.add(temp);
            }
            temp = temp.next;
        }
        return null;
    }

}
