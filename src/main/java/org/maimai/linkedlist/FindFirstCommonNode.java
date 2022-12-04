package org.maimai.linkedlist;

import org.maimai.base.ListNode;

import java.util.*;

/**
 * BM10 两个链表的第一个公共结点
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * 输入：
 * {1,2,3},{4,5},{6,7}
 * 返回值：
 * {6,7}
 *
 * @Date 2022/12/4 21:47
 * @Author chenqi
 */
public class FindFirstCommonNode {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = pHead1;
        ListNode p2 = pHead2;
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        while (p2 != null) {
            if (set.contains(p2)) {
                return p2;
            }
            p2 = p2.next;
        }
        return null;
    }
}
