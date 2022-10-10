package org.maimai.practice;

import org.maimai.base.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * @Date 2022/10/10 19:22
 * @Author chenqi
 */
public class Lc21_MergeTwoLists {

    /**
     * 1 2 3
     * 4 5 6
     * ->
     * 1 4 2 5 3 6
     * 双指针解法
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 定义新的链表
        ListNode l = new ListNode(-1);
        // 新链表的指针
        ListNode dump = l;
        // list1的指针
        ListNode l1 = list1;
        // list2的指针
        ListNode l2 = list2;
        while (l1 != null && l2 != null) {
            // 谁的值小把谁接到新的链表下面
            if (l1.val < l2.val) {
                dump.next = l1;
                l1 = l1.next;
            } else {
                dump.next = l2;
                l2 = l2.next;
            }
            dump = dump.next;
        }
        if (l1 != null) {
            dump.next = l1;
        }
        if (l2 != null) {
            dump.next = l2;
        }
        return l.next;

    }

}
