package com.fouze.linkedlist;

import com.fouze.base.ListNode;

import java.util.ArrayList;

/**
 * BM5 合并k个已排序的链表
 * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
 * <p>
 * 输入：
 * [{1,2,3},{4,5,6,7}]
 * 返回值：
 * {1,2,3,4,5,6,7}
 *
 * @Date 2022/12/2 23:43
 * @Author chenqi
 */
public class MergeKLists {

    // 分治
    // step 1：从链表数组的首和尾开始，每次划分从中间开始划分，划分成两半，得到左边n/2n/2n/2个链表和右边n/2n/2n/2个链表。
    // step 2：继续不断递归划分，直到每部分链表数为1.
    // step 3：将划分好的相邻两部分链表，按照两个有序链表合并的方式合并，合并好的两部分继续往上合并，直到最终合并成一个链表。
    // 时间复杂度O(NlogN)：N表示列表中所有链表的结点数量，首先遍历所有结点O(N)，排序O(NlogN)
    // 空间复杂度O(N)：辅助数组空间
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return div(lists, 0, lists.size() - 1);
    }


    private ListNode div(ArrayList<ListNode> lists, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return lists.get(left);
        }
        int middle = (left + right) / 2;
        return merge(div(lists, left, middle), div(lists, middle + 1, right));
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode dummyTemp = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummyTemp.next = l1;
                l1 = l1.next;
            } else {
                dummyTemp.next = l2;
                l2 = l2.next;
            }
            dummyTemp = dummyTemp.next;
        }
        if (l1 != null)
            dummyTemp.next = l1;
        if (l2 != null)
            dummyTemp.next = l2;
        return dummy.next;
    }

}
